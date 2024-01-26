// generated with ast extension for cup
// version 0.8
// 26/0/2024 21:52:13


package rs.ac.bg.etf.pp1.ast;

public class RelopGrOrEq extends Relop {

    public RelopGrOrEq () {
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
        buffer.append("RelopGrOrEq(\n");

        buffer.append(tab);
        buffer.append(") [RelopGrOrEq]");
        return buffer.toString();
    }
}
