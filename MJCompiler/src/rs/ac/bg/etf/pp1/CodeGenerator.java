package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.Obj;

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
	
	
	public void visit(StatementPrint print) { // fali obrada sa AndConst
		if(print.getAndConst().getClass() == AndConstPrint.class) {
			if(print.getExpr().struct == Tab.intType) {
				Code.put(Code.print);
			} else {
				Code.put(Code.bprint);
			}
		}
		else {
			if(print.getExpr().struct == Tab.intType) {
				Code.loadConst(5);
				Code.put(Code.print);
			} else {
				Code.loadConst(1);
				Code.put(Code.bprint);
			}
		}
		
	}
	
	public void visit(AndConstPrint p) {
		Code.loadConst(p.getNum());
	}
	
	
	
	public void visit(DesignatorStatementAssign desigAssign) {
		//na exprsteku vec imam Expr i njega samo storujem u designator
		Code.store(desigAssign.getDesignator().obj);
	}
	
	public void visit(Designtr designator) {
		SyntaxNode parent = designator.getParent();
		if(DesignatorStatementAssign.class != parent.getClass() ) {
			Code.load(designator.obj);//ukoliko nije designator iz dodele vrednosti stavi ga na stek, ako jeste ne radi nista
		}
	}
	
	public void visit(ExprAddopTerm exprAddopTerm) {
		if(exprAddopTerm.getAddop().getClass() == AddopPlus.class) {
			Code.put(Code.add);
		}
		if(exprAddopTerm.getAddop().getClass() == AddopMinus.class) {
			Code.put(Code.sub);
		}
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
	
	public void visit(FactorChar fChar) { // ne znam
		Obj obj = new Obj(Obj.Con, "charValue", Tab.charType);
		obj.setAdr(fChar.getCh().charAt(1));
		Code.load(obj);
	}
	
	public void visit(FactorExpr fExpr) { //trebalo bi da je vec na steku
		
	}

	public void visit(FactorBool fBool) { // ne znam
	
	}
	
	  
	
	public void visit(FactorDesignator fDesig) { // ne znam
//		SyntaxNode parent = fDesig.getParent();
//		if(DesignatorStatementAssign.class != parent.getClass() ) {
//			Code.load(fDesig.obj);//ukoliko nije designator iz dodele vrednosti stavi ga na stek, ako jeste ne radi nista
//		}
	}
	
	public void visit(FactorNew fNew) { // ne znam
		
	}
	
}
