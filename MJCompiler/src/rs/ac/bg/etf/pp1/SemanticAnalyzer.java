package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;



public class SemanticAnalyzer extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	int constDeclCount = 0;
	Struct currentTypeForVarOrConstDecl = null;
	Obj currentMethod = null;
	boolean returnFound = false;
	boolean errorDetected = false;
	
	Logger log = Logger.getLogger(getClass());
	
    public boolean passed(){
    	return !errorDetected;
    }
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public void visit() {
		
	}
	
    public void visit(Program program) { 
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    }
    
    public void visit(ProgName progName) {
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(VarDeclNoArray varDeclNoArray) {
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ varDeclNoArray.getVarName(), varDeclNoArray);
		Obj varNode = Tab.insert(Obj.Var, varDeclNoArray.getVarName(), varDeclNoArray.getType().struct);
		currentTypeForVarOrConstDecl = null;
	}
    
    public void visit(MoreVarDeclarations moreVarDecl) {
    	varDeclCount++;
		report_info("Deklarisana promenljiva "+ moreVarDecl.getVarName(), moreVarDecl);
    	Obj moreVarNode = Tab.insert(Obj.Var, moreVarDecl.getVarName(), currentTypeForVarOrConstDecl);
    }
    
    
    public void visit(ConstDecl constDecl) {
		constDeclCount++;
		report_info("Deklarisana konstanta "+ constDecl.getConstName(), constDecl);
		Obj constNode = Tab.insert(Obj.Con, constDecl.getConstName(), constDecl.getType().struct);
		currentTypeForVarOrConstDecl = null;
	}
    
    public void visit(MoreConstDeclarations moreConstDecl) {
		constDeclCount++;
		report_info("Deklarisana konstanta "+ moreConstDecl.getConstName(), moreConstDecl);
		Obj moreConstNode = Tab.insert(Obj.Con, moreConstDecl.getConstName(), currentTypeForVarOrConstDecl);
	}
    
    public void visit(ConstNum constNum) {
		if(currentTypeForVarOrConstDecl != Tab.intType) {
			report_error("Semanticka greska na liniji " + constNum.getLine() + ": pokusaj dodele int vrednosti konstanti koja nije tog tipa", null);
		}
	}
	
	public void visit(ConstChar constChar) {
		if(currentTypeForVarOrConstDecl != Tab.charType) {
			report_error("Semanticka greska na liniji " + constChar.getLine() + ": pokusaj dodele char vrednosti konstanti koja nije tog tipa", null);
		}
	}

	//ne valja jer nisam implementirao jos bool
	public void visit(ConstBool constBool) {
		if(currentTypeForVarOrConstDecl != Tab.charType) {
			report_error("Semanticka greska na liniji " + constBool.getLine() + ": pokusaj dodele bool vrednosti konstanti koja nije tog tipa", null);
		}
	}
    
    
    public void visit(MethodDeclNameVoid methodDeclName) {
		currentMethod = Tab.insert(Obj.Meth, methodDeclName.getMethName(), Tab.noType);
		methodDeclName.obj = currentMethod;
		Tab.openScope();
		report_info("Obradjuje se funkcija " + methodDeclName.getMethName(), methodDeclName);
	}
    
	public void visit(MethodDecl methodDecl) {
		
		if(!returnFound && currentMethod.getType() != Tab.noType) {
			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funkcija " + currentMethod.getName() + " nema return iskaz!", null);
		}
		
		Tab.chainLocalSymbols(currentMethod); // uvezujem sve simbole koji su napravljeni u ovom scope koji je otvoren kad je pocela funkcija
		Tab.closeScope(); // zatvaram scope
		
		currentMethod = null;
		returnFound = false;
	}    

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if(typeNode == Tab.noObj) {
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
			type.struct = Tab.noType;
		} else {
			if(Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
				currentTypeForVarOrConstDecl = typeNode.getType();
			} else {
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
    			type.struct = Tab.noType;
			}
		}
	}
	
	
	
	public void visit(ExprMinus expr) {
		expr.struct = expr.getTerm().struct;
	}
	
	public void visit(ExprNoMinus expr) {
		expr.struct = expr.getTerm().struct;
	}
	
	public void visit(ExprAddopTerm expr) {
		//term.struct = term.getFactor().struct;
	}
	
	
	
	
	public void visit(TermMulopFactor term) {
		//term.struct = term.getFactor().struct;
	}
	
	public void visit(FactorNoTerm term) {
		term.struct = term.getFactor().struct;
	}
	

	
	public void visit(FactorNum factorNum) {
		factorNum.struct = Tab.intType;
	}
	
	public void visit(FactorDesignator factorD) {
		factorD.struct = factorD.getDesignator().obj.getType();
	}
	
	public void visit(FactorChar factorChar) {
		factorChar.struct = Tab.charType;
	}
	
	public void visit(FactorExpr factorExpr) {

	
	}
	
	public void visit(FactorBool factorBool) {
		
		
	}
	
	public void visit(FactorNew factorNew) {

		
	}
	
	

	
	
	
//	//ne znam da li je dobro 
//	public void visit(DesignatorStatementAssign designatorStmtAs) {
//		if(designatorStmtAs.getDesignator().obj.getKind() != Obj.Var && 	
//				(!(designatorStmtAs.getDesignator() instanceof DesigntrArray) 
//						&& !(designatorStmtAs.getDesignator() instanceof DesigntrNmspArray)) ) {//fali provera da li je polje niza
//			
//			report_error("Semanticka greska na liniji " + designatorStmtAs.getLine() + ": destinaciono polje nije ni promenljiva ni element niza ", null);		
//		}
//		
//	}
	
	
}
