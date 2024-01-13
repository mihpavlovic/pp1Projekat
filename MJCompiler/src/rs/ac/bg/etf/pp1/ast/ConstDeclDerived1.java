// generated with ast extension for cup
// version 0.8
// 29/11/2023 22:47:6


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclDerived1 extends ConstDecl {

    private Type Type;
    private WhichConst WhichConst;
    private MoreConstDecls MoreConstDecls;

    public ConstDeclDerived1 (Type Type, WhichConst WhichConst, MoreConstDecls MoreConstDecls) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.WhichConst=WhichConst;
        if(WhichConst!=null) WhichConst.setParent(this);
        this.MoreConstDecls=MoreConstDecls;
        if(MoreConstDecls!=null) MoreConstDecls.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public WhichConst getWhichConst() {
        return WhichConst;
    }

    public void setWhichConst(WhichConst WhichConst) {
        this.WhichConst=WhichConst;
    }

    public MoreConstDecls getMoreConstDecls() {
        return MoreConstDecls;
    }

    public void setMoreConstDecls(MoreConstDecls MoreConstDecls) {
        this.MoreConstDecls=MoreConstDecls;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(WhichConst!=null) WhichConst.accept(visitor);
        if(MoreConstDecls!=null) MoreConstDecls.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(WhichConst!=null) WhichConst.traverseTopDown(visitor);
        if(MoreConstDecls!=null) MoreConstDecls.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(WhichConst!=null) WhichConst.traverseBottomUp(visitor);
        if(MoreConstDecls!=null) MoreConstDecls.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclDerived1(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(WhichConst!=null)
            buffer.append(WhichConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MoreConstDecls!=null)
            buffer.append(MoreConstDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclDerived1]");
        return buffer.toString();
    }
}
