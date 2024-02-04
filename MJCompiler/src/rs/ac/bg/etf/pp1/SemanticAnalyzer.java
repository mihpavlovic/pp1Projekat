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
	Obj currentNamespace = null;
	int nVars;
	
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
	
	
	
    public void visit(Program program) { 
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    }
    
    public void visit(ProgName progName) {
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    
    //smene za deklaracije promenljivih, nizova i konstanti
    
    public void visit(VarDeclNoArray varDeclNoArray) {
		varDeclCount++;
		String varName;
		if(currentNamespace == null) {
			varName = varDeclNoArray.getVarName();
		}
		else {
			varName = currentNamespace.getName() + "::" + varDeclNoArray.getVarName();
		}
		if(Tab.find(varName)!= Tab.noObj) {
			report_error("Semanticka greska na liniji " + varDeclNoArray.getLine() + ": promenljiva je vec prethodno deklarisana", null);
		}
		else {
			report_info("Deklarisana promenljiva "+ varName, varDeclNoArray);
			Obj varNode = Tab.insert(Obj.Var, varName, varDeclNoArray.getType().struct);
		}
		
		currentTypeForVarOrConstDecl = null;
	}
    
    public void visit(MoreVarDeclarations moreVarDecl) {
    	varDeclCount++;
    	String varName;
		if(currentNamespace == null) {
			varName = moreVarDecl.getVarName();
		}
		else {
			varName = currentNamespace.getName() + "::" + moreVarDecl.getVarName();
		}
		if(Tab.find(varName)!= Tab.noObj) {
			report_error("Semanticka greska na liniji " + moreVarDecl.getLine() + ": promenljiva je vec prethodno deklarisana", null);
		}
		else {
			report_info("Deklarisana promenljiva "+ varName + " na liniji " + moreVarDecl.getLine(), null);
	    	Obj moreVarNode = Tab.insert(Obj.Var, varName, currentTypeForVarOrConstDecl);	
		}
		
    }
    
    public void visit(VarDeclArray varDeclArray) {
    	String arrayName;
		if(currentNamespace == null) {
			arrayName = varDeclArray.getArrayName();
		}
		else {
			arrayName = currentNamespace.getName() + "::" + varDeclArray.getArrayName();
		}
		if(Tab.find(arrayName)!= Tab.noObj) {
			report_error("Semanticka greska na liniji " + varDeclArray.getLine() + ": niz je vec prethodno deklarisan", null);
		}
		else {
			report_info("Deklarisan niz "+ arrayName, varDeclArray);
			//pravim prvo strukturni cvor
			Struct arrayStructNode = new Struct(Struct.Array, varDeclArray.getType().struct);
			Obj varArrayNode = Tab.insert(Obj.Var, arrayName, arrayStructNode);
		}
		currentTypeForVarOrConstDecl = null;
	}
    
    public void visit(MoreVarDeclarationsArray moreVarDelcArray) {
    	String arrayName;
    	if(currentNamespace == null) {
    		arrayName = moreVarDelcArray.getArrayName();
    	}
    	else {
    		arrayName = currentNamespace.getName() + "::" + moreVarDelcArray.getArrayName();
    	}
    	if(Tab.find(arrayName)!= Tab.noObj) {
    		report_error("Semanticka greska na liniji " + moreVarDelcArray.getLine() + ": promenljiva je vec prethodno deklarisana", null);
    	}
    	else {
    		report_info("Deklarisan niz "+ arrayName, moreVarDelcArray);
    		Struct arrayStructNode = new Struct(Struct.Array, currentTypeForVarOrConstDecl);
    		Obj moreVarArrayNode = Tab.insert(Obj.Var, arrayName, arrayStructNode);
    	}
    }
    
    public void visit(ConstDecl constDecl) {
		constDeclCount++;
		String constName;
		if(currentNamespace == null) {
			constName = constDecl.getConstName();
		}
		else {
			constName = currentNamespace.getName() + "::" + constDecl.getConstName();
		}
		if(Tab.find(constName)!= Tab.noObj) {
    		report_error("Semanticka greska na liniji " + constDecl.getLine() + ": promenljiva je vec prethodno deklarisana", null);
    	}
		else {
			report_info("Deklarisana konstanta "+ constName, constDecl);
			Obj constNode = Tab.insert(Obj.Con, constName, constDecl.getType().struct);
			constDecl.obj = constNode;
		}
		currentTypeForVarOrConstDecl = null;
	}
    
    public void visit(MoreConstDeclarations moreConstDecl) {
		constDeclCount++;
		String constName;
		if(currentNamespace == null) {
			constName = moreConstDecl.getConstName();
		}
		else {
			constName = currentNamespace.getName() + "::" + moreConstDecl.getConstName();
		}
		if(Tab.find(constName)!= Tab.noObj) {
    		report_error("Semanticka greska na liniji " + moreConstDecl.getLine() + ": promenljiva je vec prethodno deklarisana", null);
    	}
		else {
			report_info("Deklarisana konstanta "+ constName, moreConstDecl);
			Obj moreConstNode = Tab.insert(Obj.Con, constName, currentTypeForVarOrConstDecl);
			moreConstDecl.obj = moreConstNode;
		}
    }
    
    public void visit(ConstNum constNum) { // samo gleda da li se tip vrednosti koja je data slaze za currentType promenljivom, isto vazi i za char i za bool
		if(currentTypeForVarOrConstDecl != Tab.intType) {
			report_error("Semanticka greska na liniji " + constNum.getLine() + ": pokusaj dodele int vrednosti konstanti koja nije tog tipa", null);
		}
	}
	
	public void visit(ConstChar constChar) {
		if(currentTypeForVarOrConstDecl != Tab.charType) {
			report_error("Semanticka greska na liniji " + constChar.getLine() + ": pokusaj dodele char vrednosti konstanti koja nije tog tipa", null);
		}
	}

	public void visit(ConstBool constBool) {
		if(currentTypeForVarOrConstDecl != TabExtended.boolType) {
			report_error("Semanticka greska na liniji " + constBool.getLine() + ": pokusaj dodele bool vrednosti konstanti koja nije tog tipa", null);
		}
	}
    
	
	//smene za Namespace
	
	public void visit(NamespName namespName) {
		currentNamespace = Tab.insert(ObjExtended.Nmsp, namespName.getNmspName(), Tab.noType);
		namespName.obj = currentNamespace;
		report_info("Obradjuje se prostor imena: " + namespName.getNmspName(), namespName);
	}
	
	public void visit(Namesp namesp) {
		currentNamespace = null;
	}
	
	
	//smene za metode
    	
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
	
	
	//smene za lokalne promenljive metode
	
	public void visit(VarDeclarationsInFunc varDecl) {
		varDeclCount++;
		String varName; //nema lokalnih simbola vraca null ako ima i nije medju njima vraca Tab.noObj
		varName = varDecl.getVarName();
		if(Tab.currentScope.findSymbol(varName)!= null && Tab.currentScope.findSymbol(varName)!= Tab.noObj) {
			report_error("Semanticka greska na liniji " + varDecl.getLine() + ": lokalna promenljiva je vec prethodno deklarisana", null);
		}
		else {
			report_info("Deklarisana lokalna promenljiva "+ varDecl.getVarName() + " na liniji "+ varDecl.getLine(), null);
			Obj varNode = Tab.insert(Obj.Var, varName, varDecl.getType().struct);
		}
		
		currentTypeForVarOrConstDecl = null;
	}
	
	public void visit(VarDeclarationsInFuncArray varDeclArr) {
		String arrName = varDeclArr.getArrayName();
		if(Tab.currentScope.findSymbol(arrName)!= null && Tab.currentScope.findSymbol(arrName)!= Tab.noObj) {
			report_error("Semanticka greska na liniji " + varDeclArr.getLine() + ": lokalni niz je vec prethodno deklarisan", null);
		}
		else {
			report_info("Deklarisana lokalni niz "+ arrName + " na liniji "+ varDeclArr.getLine(), null);
			Struct arrayStructNode = new Struct(Struct.Array, varDeclArr.getType().struct);
			Obj varArrayNode = Tab.insert(Obj.Var, arrName, arrayStructNode);

		}
		currentTypeForVarOrConstDecl = null;
	}
	
	
	//smena za tip

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
	
	
	//Statement za print i read
	
	public void visit(StatementPrint stmtPrint) {
		if(stmtPrint.getExpr().struct != Tab.intType && stmtPrint.getExpr().struct != Tab.charType && stmtPrint.getExpr().struct != TabExtended.boolType) {
			report_error("Semanticka greska na liniji "+ stmtPrint.getLine() + " : funkciji print je prosledjen parametar koji nije ni int ni char ni bool tipa",null);
		}
		printCallCount++;
	}
	
	public void visit(StatementRead stmtRead) {
		if(stmtRead.getDesignator().obj.getKind() != Obj.Var && stmtRead.getDesignator().obj.getKind() != Obj.Elem) {
			report_error("Greska na liniji " + stmtRead.getLine() + " : designator u read iskazu nije ni promenljiva ni element niza.",null);
		}
		if(stmtRead.getDesignator().obj.getType() != Tab.intType && stmtRead.getDesignator().obj.getType() != Tab.charType && stmtRead.getDesignator().obj.getType() != TabExtended.boolType) {
			report_error("Greska na liniji " + stmtRead.getLine() + " : designator u read iskazu nije tipa int, char ili bool.",null);
		}
	}
	
	
	//Smene za DesignatorStatement i za Designator
	
	public void visit(Designtr designator) {
		Obj obj = Tab.find(designator.getName());
		if(obj == Tab.noObj) {
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getName()+" nije deklarisano! ", null);
		}
		designator.obj = obj;
	}
	
	public void visit(DesigntrNmsp designator) {
		String dsName = designator.getNmspName() + "::" + designator.getName();
		Obj obj = Tab.find(dsName);
		if(obj == Tab.noObj) {
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+dsName+" nije deklarisano! ", null);
		}
		designator.obj = obj;
	}
		
	public void visit(DesigntrArray desigArray) {
		String arrayName;
		if(desigArray.getDesignator() instanceof Designtr) {
			arrayName = ((Designtr)(desigArray.getDesignator())).getName();
		} else if(desigArray.getDesignator() instanceof DesigntrNmsp) {
			arrayName = ((DesigntrNmsp)(desigArray.getDesignator())).getNmspName() + "::" +((DesigntrNmsp)(desigArray.getDesignator())).getName();
		} else {
			report_error("Semanticka greska na liniji " + desigArray.getLine() + " : losa kombinacija Designatora", null);
			arrayName = "";
		}
		Obj arr = Tab.find(arrayName);
		if(arr == Tab.noObj) {
			report_error("Greska na liniji " + desigArray.getLine()+ " : ne postoji niz sa imenom "+arrayName, null);
		}
		Obj elemOfArr = new Obj(Obj.Elem, arrayName, arr.getType().getElemType());
		desigArray.obj = elemOfArr;
	}
	
	public void visit(DesignatorStatementAssign desigStAss) {
		if(!desigStAss.getExpr().struct.assignableTo(desigStAss.getDesignator().obj.getType())) {
    		report_error("Greska na liniji " + desigStAss.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);

		}
	}
	
	public void visit(DesignatorStatementInc dsgStmt) {
		if(dsgStmt.getDesignator().obj.getKind() != Obj.Var && dsgStmt.getDesignator().obj.getKind() != Obj.Elem) {
			report_error("Greska na liniji " + dsgStmt.getLine() + " : designator u ++ iskazu nije ni promenljiva ni element niza.",null);
		}
		if(dsgStmt.getDesignator().obj.getType() != Tab.intType) {
			report_error("Greska na liniji " + dsgStmt.getLine() + " : designator u ++ iskazu nije tipa int.",null);
		}
	}
	
	public void visit(DesignatorStatementDec dsgStmt) {
		if(dsgStmt.getDesignator().obj.getKind() != Obj.Var && dsgStmt.getDesignator().obj.getKind() != Obj.Elem) {
			report_error("Greska na liniji " + dsgStmt.getLine() + " : designator u -- iskazu nije ni promenljiva ni element niza.",null);
		}
		if(dsgStmt.getDesignator().obj.getType() != Tab.intType) {
			report_error("Greska na liniji " + dsgStmt.getLine() + " : designator u -- iskazu nije tipa int.",null);
		}
	}
	
	
	//Term, Expr, Factor smene
	
	public void visit(ExprMinus expr) {
		if(expr.getTerm().struct == Tab.intType) {
			expr.struct = expr.getTerm().struct;		
		} else {
			report_error("Greska na liniji : " + expr.getLine() + "tip nije int", expr);
			expr.struct = Tab.noType;
		}
	}
	
	public void visit(ExprNoMinus expr) {
		expr.struct = expr.getTerm().struct;
	}
	
	public void visit(ExprAddopTerm expr) { // mozda fali nesto za niz, ustanovio sam da ne fali
		Struct stExpr = expr.getExpr().struct;
		Struct stTerm = expr.getTerm().struct;
		if(!stExpr.compatibleWith(stTerm)) {
			report_error("Tipovi su nekompatibilni u izrazu za sabiranje na liniji : " + expr.getLine(), expr);
		}
		else {
			if(stExpr.equals(stTerm) && stExpr == Tab.intType) {
				expr.struct = stExpr;
			}
			else {
				report_error("Greska na liniji "+ expr.getLine()+" : u izrazu za sabiranje tipovi nisu int.", null);
			}
		}
		
	}
	
	public void visit(TermMulopFactor term) {
		Struct stFactor = term.getFactor().struct;
		Struct stTerm = term.getTerm().struct;
		if(!stFactor.compatibleWith(stTerm)) {
			report_error("Tipovi su nekompatibilni u izrazu za mnozenje na liniji : " + term.getLine(), term);
		}
		else {
			if(stFactor.equals(stTerm) && stFactor == Tab.intType) {
				term.struct = stFactor;
			}
			else {
				report_error("Greska na liniji "+ term.getLine()+" : u izrazu za sabiranje tipovi nisu int.", null);
			}
		}	
	}
	
	public void visit(FactorNoTerm term) {
		term.struct = term.getFactor().struct;
	}
	
	public void visit(FactorNum factorNum) {
		factorNum.struct = Tab.intType;
	}
	
	public void visit(FactorDesignator factorD) { // moguce da fali nesto za element niza
		factorD.struct = factorD.getDesignator().obj.getType();
	}
	
	public void visit(FactorChar factorChar) {
		factorChar.struct = Tab.charType;
	}
	
	public void visit(FactorExpr factorExpr) {
		factorExpr.struct = factorExpr.getExpr().struct;
	
	}
	
	public void visit(FactorBool factorBool) {
		factorBool.struct = TabExtended.boolType;
		
	}
	
	public void visit(FactorNew factorNew) {
		if(factorNew.getExpr().struct != Tab.intType) {
			report_error("Semanticka greska na liniji "+ factorNew.getLine() + " vrednost u uglastim zagradama nije tipa int.", null);
		}
		Struct arrayStructNode = new Struct(Struct.Array, factorNew.getType().struct);
		factorNew.struct = arrayStructNode;
		
	}
	
	
}
