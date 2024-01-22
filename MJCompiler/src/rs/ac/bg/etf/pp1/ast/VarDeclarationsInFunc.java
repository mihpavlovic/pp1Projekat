// generated with ast extension for cup
// version 0.8
// 22/0/2024 23:28:10


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationsInFunc extends VarDeclInFunc {

    private VarDeclInFunc VarDeclInFunc;
    private Type Type;
    private String varName;

    public VarDeclarationsInFunc (VarDeclInFunc VarDeclInFunc, Type Type, String varName) {
        this.VarDeclInFunc=VarDeclInFunc;
        if(VarDeclInFunc!=null) VarDeclInFunc.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.varName=varName;
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

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclInFunc!=null) VarDeclInFunc.accept(visitor);
        if(Type!=null) Type.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclInFunc!=null) VarDeclInFunc.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclInFunc!=null) VarDeclInFunc.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationsInFunc(\n");

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

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationsInFunc]");
        return buffer.toString();
    }
}
