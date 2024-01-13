// generated with ast extension for cup
// version 0.8
// 29/11/2023 22:47:6


package rs.ac.bg.etf.pp1.ast;

public class VarDeclInFuncDerived1 extends VarDeclInFunc {

    private VarDeclInFunc VarDeclInFunc;
    private Type Type;

    public VarDeclInFuncDerived1 (VarDeclInFunc VarDeclInFunc, Type Type) {
        this.VarDeclInFunc=VarDeclInFunc;
        if(VarDeclInFunc!=null) VarDeclInFunc.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
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
        buffer.append("VarDeclInFuncDerived1(\n");

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

        buffer.append(tab);
        buffer.append(") [VarDeclInFuncDerived1]");
        return buffer.toString();
    }
}
