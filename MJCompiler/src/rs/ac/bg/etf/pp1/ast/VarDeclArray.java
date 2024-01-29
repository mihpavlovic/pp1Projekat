// generated with ast extension for cup
// version 0.8
// 29/0/2024 14:42:54


package rs.ac.bg.etf.pp1.ast;

public class VarDeclArray extends VarDecl {

    private Type Type;
    private String arrayName;
    private MoreVarDecls MoreVarDecls;

    public VarDeclArray (Type Type, String arrayName, MoreVarDecls MoreVarDecls) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.arrayName=arrayName;
        this.MoreVarDecls=MoreVarDecls;
        if(MoreVarDecls!=null) MoreVarDecls.setParent(this);
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
        if(Type!=null) Type.accept(visitor);
        if(MoreVarDecls!=null) MoreVarDecls.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MoreVarDecls!=null) MoreVarDecls.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MoreVarDecls!=null) MoreVarDecls.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclArray(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+arrayName);
        buffer.append("\n");

        if(MoreVarDecls!=null)
            buffer.append(MoreVarDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclArray]");
        return buffer.toString();
    }
}
