// generated with ast extension for cup
// version 0.8
// 25/0/2024 14:32:21


package rs.ac.bg.etf.pp1.ast;

public class RelopDiff extends Relop {

    public RelopDiff () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RelopDiff(\n");

        buffer.append(tab);
        buffer.append(") [RelopDiff]");
        return buffer.toString();
    }
}
