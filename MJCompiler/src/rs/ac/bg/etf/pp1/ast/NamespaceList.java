// generated with ast extension for cup
// version 0.8
// 26/0/2024 11:48:7


package rs.ac.bg.etf.pp1.ast;

public class NamespaceList extends NamespList {

    private NamespList NamespList;
    private Namesp Namesp;

    public NamespaceList (NamespList NamespList, Namesp Namesp) {
        this.NamespList=NamespList;
        if(NamespList!=null) NamespList.setParent(this);
        this.Namesp=Namesp;
        if(Namesp!=null) Namesp.setParent(this);
    }

    public NamespList getNamespList() {
        return NamespList;
    }

    public void setNamespList(NamespList NamespList) {
        this.NamespList=NamespList;
    }

    public Namesp getNamesp() {
        return Namesp;
    }

    public void setNamesp(Namesp Namesp) {
        this.Namesp=Namesp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NamespList!=null) NamespList.accept(visitor);
        if(Namesp!=null) Namesp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NamespList!=null) NamespList.traverseTopDown(visitor);
        if(Namesp!=null) Namesp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NamespList!=null) NamespList.traverseBottomUp(visitor);
        if(Namesp!=null) Namesp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NamespaceList(\n");

        if(NamespList!=null)
            buffer.append(NamespList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Namesp!=null)
            buffer.append(Namesp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NamespaceList]");
        return buffer.toString();
    }
}
