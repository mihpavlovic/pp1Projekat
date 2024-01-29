// generated with ast extension for cup
// version 0.8
// 29/0/2024 14:42:54


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationsInFuncArray extends VarDeclInFunc {

    private VarDeclInFunc VarDeclInFunc;
    private Type Type;
    private String arrayName;

    public VarDeclarationsInFuncArray (VarDeclInFunc VarDeclInFunc, Type Type, String arrayName) {
        this.VarDeclInFunc=VarDeclInFunc;
        if(VarDeclInFunc!=null) VarDeclInFunc.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.arrayName=arrayName;
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

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName=arrayName;
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
        buffer.append("VarDeclarationsInFuncArray(\n");

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

        buffer.append(" "+tab+arrayName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationsInFuncArray]");
        return buffer.toString();
    }
}
