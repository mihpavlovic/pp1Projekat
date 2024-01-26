// generated with ast extension for cup
// version 0.8
// 26/0/2024 16:33:3


package rs.ac.bg.etf.pp1.ast;

public class MoreConstDeclarations extends MoreConstDecls {

    private MoreConstDecls MoreConstDecls;
    private String constName;
    private WhichConst WhichConst;

    public MoreConstDeclarations (MoreConstDecls MoreConstDecls, String constName, WhichConst WhichConst) {
        this.MoreConstDecls=MoreConstDecls;
        if(MoreConstDecls!=null) MoreConstDecls.setParent(this);
        this.constName=constName;
        this.WhichConst=WhichConst;
        if(WhichConst!=null) WhichConst.setParent(this);
    }

    public MoreConstDecls getMoreConstDecls() {
        return MoreConstDecls;
    }

    public void setMoreConstDecls(MoreConstDecls MoreConstDecls) {
        this.MoreConstDecls=MoreConstDecls;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
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
        buffer.append("MoreConstDeclarations(\n");

        if(MoreConstDecls!=null)
            buffer.append(MoreConstDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        if(WhichConst!=null)
            buffer.append(WhichConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreConstDeclarations]");
        return buffer.toString();
    }
}
