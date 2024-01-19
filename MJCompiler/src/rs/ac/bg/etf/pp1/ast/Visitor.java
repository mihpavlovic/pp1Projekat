// generated with ast extension for cup
// version 0.8
// 17/0/2024 17:35:12


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Designator Designator);
    public void visit(Factor Factor);
    public void visit(Mulop Mulop);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(MoreVarDecls MoreVarDecls);
    public void visit(VarDeclInFunc VarDeclInFunc);
    public void visit(Declarations Declarations);
    public void visit(DesigNmsp DesigNmsp);
    public void visit(Expr Expr);
    public void visit(AndConst AndConst);
    public void visit(MoreConstDecls MoreConstDecls);
    public void visit(VarDecl VarDecl);
    public void visit(Addop Addop);
    public void visit(DesigBracket DesigBracket);
    public void visit(NamespList NamespList);
    public void visit(WhichConst WhichConst);
    public void visit(Statement Statement);
    public void visit(Relop Relop);
    public void visit(Term Term);
    public void visit(MethodDeclName MethodDeclName);
    public void visit(StatementList StatementList);
    public void visit(RelopDiff RelopDiff);
    public void visit(RelopEq RelopEq);
    public void visit(RelopLeOrEq RelopLeOrEq);
    public void visit(RelopGrOrEq RelopGrOrEq);
    public void visit(RelopLe RelopLe);
    public void visit(RelopGr RelopGr);
    public void visit(MulopMod MulopMod);
    public void visit(MulopDiv MulopDiv);
    public void visit(MulopMul MulopMul);
    public void visit(AddopPlus AddopPlus);
    public void visit(AddopMinus AddopMinus);
    public void visit(FactorNew FactorNew);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(FactorBool FactorBool);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNum FactorNum);
    public void visit(FactorNoTerm FactorNoTerm);
    public void visit(TermMulopFactor TermMulopFactor);
    public void visit(ExprAddopTerm ExprAddopTerm);
    public void visit(ExprNoMinus ExprNoMinus);
    public void visit(ExprMinus ExprMinus);
    public void visit(DesigntrNmsp DesigntrNmsp);
    public void visit(DesigntrArray DesigntrArray);
    public void visit(Designtr Designtr);
    public void visit(DesigntrNmspArray DesigntrNmspArray);
    public void visit(DesignatorStatementDec DesignatorStatementDec);
    public void visit(DesignatorStatementInc DesignatorStatementInc);
    public void visit(DesignatorStatementAssign DesignatorStatementAssign);
    public void visit(NoAndConstPrint NoAndConstPrint);
    public void visit(AndConstPrint AndConstPrint);
    public void visit(ErrorStmt ErrorStmt);
    public void visit(StatementPrint StatementPrint);
    public void visit(StatementRead StatementRead);
    public void visit(StatementDesignatorStatement StatementDesignatorStatement);
    public void visit(NoStmtList NoStmtList);
    public void visit(StmtList StmtList);
    public void visit(NoVarDeclarationsInFunc NoVarDeclarationsInFunc);
    public void visit(VarDeclarationsInFunc VarDeclarationsInFunc);
    public void visit(VarDeclarationsInFuncArray VarDeclarationsInFuncArray);
    public void visit(FormPars FormPars);
    public void visit(MethodDeclNameVoid MethodDeclNameVoid);
    public void visit(MethodDeclNameType MethodDeclNameType);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMoreVarDeclarations NoMoreVarDeclarations);
    public void visit(MoreVarDeclarations MoreVarDeclarations);
    public void visit(MoreVarDeclarationsArray MoreVarDeclarationsArray);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(NoMoreConstDeclarations NoMoreConstDeclarations);
    public void visit(MoreConstDeclarations MoreConstDeclarations);
    public void visit(ConstBool ConstBool);
    public void visit(ConstChar ConstChar);
    public void visit(ConstNum ConstNum);
    public void visit(Type Type);
    public void visit(ErrorStmtVar ErrorStmtVar);
    public void visit(VarDeclNoArray VarDeclNoArray);
    public void visit(VarDeclArray VarDeclArray);
    public void visit(ConstDecl ConstDecl);
    public void visit(NoDeclarations NoDeclarations);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ConstDeclarations ConstDeclarations);
    public void visit(NamespName NamespName);
    public void visit(Namesp Namesp);
    public void visit(NoNamespaceList NoNamespaceList);
    public void visit(NamespaceList NamespaceList);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
