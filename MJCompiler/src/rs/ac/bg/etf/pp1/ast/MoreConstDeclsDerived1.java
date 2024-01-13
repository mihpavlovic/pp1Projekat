// generated with ast extension for cup
// version 0.8
// 29/11/2023 22:47:6


package rs.ac.bg.etf.pp1.ast;

public class MoreConstDeclsDerived1 extends MoreConstDecls {

    private MoreConstDecls MoreConstDecls;
    private WhichConst WhichConst;

    public MoreConstDeclsDerived1 (MoreConstDecls MoreConstDecls, WhichConst WhichConst) {
        this.MoreConstDecls=MoreConstDecls;
        if(MoreConstDecls!=null) MoreConstDecls.setParent(this);
        this.WhichConst=WhichConst;
        if(WhichConst!=null) WhichConst.setParent(this);
    }

    public MoreConstDecls getMoreConstDecls() {
        return MoreConstDecls;
    }

    public void setMoreConstDecls(MoreConstDecls MoreConstDecls) {
        this.MoreConstDecls=MoreConstDecls;
    }

    public WhichConst getWhichConst() {
        return WhichConst;
    }

    public void setWhichConst(WhichConst WhichConst) {
        this.WhichConst=WhichConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MoreConstDecls!=null) MoreConstDecls.accept(visitor);
        if(WhichConst!=null) WhichConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MoreConstDecls!=null) MoreConstDecls.traverseTopDown(visitor);
        if(WhichConst!=null) WhichConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MoreConstDecls!=null) MoreConstDecls.traverseBottomUp(visitor);
        if(WhichConst!=null) WhichConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MoreConstDeclsDerived1(\n");

        if(MoreConstDecls!=null)
            buffer.append(MoreConstDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(WhichConst!=null)
            buffer.append(WhichConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreConstDeclsDerived1]");
        return buffer.toString();
    }
}
