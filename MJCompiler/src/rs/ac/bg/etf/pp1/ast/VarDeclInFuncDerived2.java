// generated with ast extension for cup
// version 0.8
// 29/11/2023 22:47:6


package rs.ac.bg.etf.pp1.ast;

public class VarDeclInFuncDerived2 extends VarDeclInFunc {

    private VarDeclInFunc VarDeclInFunc;
    private Type Type;
    private MoreVarDecls MoreVarDecls;

    public VarDeclInFuncDerived2 (VarDeclInFunc VarDeclInFunc, Type Type, MoreVarDecls MoreVarDecls) {
        this.VarDeclInFunc=VarDeclInFunc;
        if(VarDeclInFunc!=null) VarDeclInFunc.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.MoreVarDecls=MoreVarDecls;
        if(MoreVarDecls!=null) MoreVarDecls.setParent(this);
    }

    public VarDeclInFunc getVarDeclInFunc() {
        return VarDeclInFunc;
    }

    public void setVarDeclInFunc(VarDeclInFunc VarDeclInFunc) {
        this.VarDeclInFunc=VarDeclInFunc;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public MoreVarDecls getMoreVarDecls() {
        return MoreVarDecls;
    }

    public void setMoreVarDecls(MoreVarDecls MoreVarDecls) {
        this.MoreVarDecls=MoreVarDecls;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclInFunc!=null) VarDeclInFunc.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(MoreVarDecls!=null) MoreVarDecls.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclInFunc!=null) VarDeclInFunc.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MoreVarDecls!=null) MoreVarDecls.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclInFunc!=null) VarDeclInFunc.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MoreVarDecls!=null) MoreVarDecls.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclInFuncDerived2(\n");

        if(VarDeclInFunc!=null)
            buffer.append(VarDeclInFunc.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MoreVarDecls!=null)
            buffer.append(MoreVarDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclInFuncDerived2]");
        return buffer.toString();
    }
}
