// generated with ast extension for cup
// version 0.8
// 29/11/2023 22:47:6


package rs.ac.bg.etf.pp1.ast;

public class NamespListDerived1 extends NamespList {

    private NamespList NamespList;
    private Namesp Namesp;

    public NamespListDerived1 (NamespList NamespList, Namesp Namesp) {
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
        buffer.append("NamespListDerived1(\n");

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
        buffer.append(") [NamespListDerived1]");
        return buffer.toString();
    }
}
