package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;

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
		if(print.getExpr().struct == Tab.intType) {
			Code.loadConst(5);
			Code.put(Code.print);
		} else {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	
	public void visit(FactorNum fNum) {
		Code.loadConst(fNum.getNum());
	}
}
