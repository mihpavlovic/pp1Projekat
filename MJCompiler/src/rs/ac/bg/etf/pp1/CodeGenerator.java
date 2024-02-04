package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(MethodDeclNameVoid methName) {
		if("main".equalsIgnoreCase(methName.getMethName())) {
			mainPc = Code.pc;
		}
		methName.obj.setAdr(Code.pc);
		
		//dohvatanje broja lokalnih promenljivih, svakako nema parametara pa ih ni ne gledam
		SyntaxNode methNode = methName.getParent();
		VarCounter varCounter = new VarCounter();
		methNode.traverseTopDown(varCounter);
		
		//generisem entry naredbu
		Code.put(Code.enter);
		Code.put(0); // ovde ide broj parametara, posto ij nema ide 0
		Code.put(varCounter.getCount()); // broj parametara + broj lokalnih promenljivih	
	}
	
	public void visit(MethodDecl methDecl) {
		// ovde idu instrukcije koje treba da nkraju funkcije da se dodaju
		Code.put(Code.exit);
		Code.put(Code.return_); // za ovu nisam siguran da li treba posto nema nikakve povratne vrednosti jer je main void
	}
	
	
	public void visit(StatementPrint print) { 
		if(print.getAndConst().getClass() == AndConstPrint.class) { // ovo je ako ima AndConst i ako ga ima ta vrednost je vec na steku
			if(print.getExpr().struct == Tab.charType) {
				Code.put(Code.bprint);
			} else {
				Code.put(Code.print);
			}
		}
		else {
			if(print.getExpr().struct == Tab.charType) {
				Code.loadConst(1);
				Code.put(Code.bprint);
			} else {
				Code.loadConst(5);
				Code.put(Code.print);
			}
		}
		
	}
	
	public void visit(AndConstPrint p) {
		Code.loadConst(p.getNum());
	}
	
	public void visit(StatementRead read) {
		if(read.getDesignator().obj.getType() == Tab.charType) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}
		Code.store(read.getDesignator().obj);
	}
	
	
	//pomocna funkcija za vracanje vrednosti konstanti, ne moze bez nje jer svaki tip konstante ima drugi atribut koji treba da vrati, ovako je uniformno za sve
	private int cnstValue(SyntaxNode node) {
		if(node instanceof ConstNum) {
			return ((ConstNum)node).getNumValue();
		}
		if(node instanceof ConstChar) {
			return ((ConstChar)node).getCharValue().charAt(1);
		}
		if(node instanceof ConstBool) {
			String boolValue = ((ConstBool)node).getBoolValue();
			if("true".equalsIgnoreCase(boolValue)) {
				return 1;
			} else {
				return 0;
			}
		}
		return -1; // u slucaju da nesto nije kako treba 
	}
	
	
	//deklaracije konstanti
	
	public void visit(ConstDecl constDecl) { // kod konstanti se njihova vrednost cuva u njihovoj adresi
		constDecl.obj.setAdr(cnstValue(constDecl.getWhichConst()));
	}
	
	public void visit(MoreConstDeclarations moreConstDecl) {
		moreConstDecl.obj.setAdr(cnstValue(moreConstDecl.getWhichConst()));
	}
	
	public void visit(ConstNum cNum) {
		Code.loadConst(cNum.getNumValue());
	}
	
	public void visit(ConstChar cChar) { 
		Code.loadConst(cChar.getCharValue().charAt(1));
	}
	
	public void visit(ConstBool cBool) { //u dosadasnjim fazama je vrednost za bool String i ovde mora da se prebaci u int
		if("true".equalsIgnoreCase(cBool.getBoolValue())) {
			Code.loadConst(1);
		} else {
			Code.loadConst(0);
		}
	}
	
	
	//sve za Designator, DesignatorStatement
	
	public void visit(DesignatorStatementAssign desigAssign) {
		//na exprsteku vec imam Expr i njega samo storujem u designator
	
		Code.store(desigAssign.getDesignator().obj);
		
	}
	
	public void visit(DesignatorStatementInc dsStmt) { // potreban store jer ne ide preko assign operatora
		
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(dsStmt.getDesignator().obj);

	}
	
	public void visit(DesignatorStatementDec dsStmt) {
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(dsStmt.getDesignator().obj);

	}
	
	public void visit(Designtr designator) {
		SyntaxNode parent = designator.getParent();
		if(DesignatorStatementAssign.class != parent.getClass() && StatementRead.class != parent.getClass()) { // za read mi ne treba designator na steku jer se tu samo u njega upisuje, njegova prethodna vr je nebitna 
			Code.load(designator.obj);//ukoliko nije designator iz dodele vrednosti stavi ga na stek, ako jeste ne radi nista
		}
	}
	
	public void visit(DesigntrNmsp dsNmsp) {
		SyntaxNode parent = dsNmsp.getParent();
		if(DesignatorStatementAssign.class != parent.getClass() && StatementRead.class != parent.getClass()) {
			Code.load(dsNmsp.obj);
		}
	}
	
	// u Desugntr i DesigntrNmsp sam stavio adresu niza na exprStek
	public void visit(DesigntrArray dsArr) { // adresa i indeks su vec na steku, ovde dodajem aload i dup2 ako je potreban
		SyntaxNode parent = dsArr.getParent();
		if(parent instanceof DesignatorStatementAssign || parent instanceof StatementRead) { // ako je dsArr sa leve strane jednako u dodeli vrednosti ne treba da se stavlja na exprStek
			
		} else {
			if(parent instanceof DesignatorStatementInc || parent instanceof DesignatorStatementDec) { //mora ovde da se doradi zbog aload, on skida te tr i stavlja vrednost te u inc i dec nemam sta da dupliram onda
				Code.put(Code.dup2);
			}
			Code.load(dsArr.obj); // u Code.load gleda da l je char ili int
		}

	}
	

	
	
	//sve za Expr, izraze i operacije
	
	public void visit(ExprAddopTerm exprAddopTerm) { // operandi su vec na exprSteku, ovde samo stavljam koja operacija treba da se uradi
		if(exprAddopTerm.getAddop().getClass() == AddopPlus.class) {
			Code.put(Code.add);
		}
		if(exprAddopTerm.getAddop().getClass() == AddopMinus.class) {
			Code.put(Code.sub);
		}
	}
	
	public void visit(ExprMinus exprMinus) { //operand je vec na steku
		Code.put(Code.neg);
	}
	
	public void visit(TermMulopFactor termMulopFactor) {
		if(termMulopFactor.getMulop().getClass() == MulopMul.class) {
			Code.put(Code.mul);
		}
		if(termMulopFactor.getMulop().getClass() == MulopDiv.class) {
			Code.put(Code.div);
		}
		if(termMulopFactor.getMulop().getClass() == MulopMod.class) {
			Code.put(Code.rem); // ovo bi trebalo da je ostatak
		}
	}
	
	public void visit(FactorNum fNum) {
		Code.loadConst(fNum.getNum());
	}
	
	public void visit(FactorChar fChar) { // char stavljam na exprStek, posto nije int pravim cvor i postavljam adresu i radim load a ne loadConst sa samim charom
		Obj obj = new Obj(Obj.Con, "charValue", Tab.charType);
		obj.setAdr(fChar.getCh().charAt(1));
		Code.load(obj);
	}
	
	public void visit(FactorExpr fExpr){ // vec je na exprSteku preko Expr smene
		
	}

	public void visit(FactorBool fBool) { // u dosadasnjim fazama je vrednost za bool String i ovde mora da se prebaci u int
		if("true".equalsIgnoreCase(fBool.getBl())) {
			Code.loadConst(1);
		} else {
			Code.loadConst(0);
		}
	}
	
	public void visit(FactorDesignator fDesig) { // vec je na exprSteku preko designatora

	}
	
	public void visit(FactorNew fNew) { //instrukcija za pravljenje novog niza, duzina je preko smene expr vec na exprSteku
		Code.put(Code.newarray);
		if(fNew.getType().struct == Tab.charType) {
			Code.put(0);
		} else { // bool je realizovan kao int (false = 0 , true = 1) tako da ide isto kao int
			Code.put(1);
		}
		
	}
	
}
