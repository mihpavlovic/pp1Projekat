// generated with ast extension for cup
// version 0.8
// 29/0/2024 14:42:54


package rs.ac.bg.etf.pp1.ast;

public class RelopLe extends Relop {

    public RelopLe () {
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
        buffer.append("RelopLe(\n");

        buffer.append(tab);
        buffer.append(") [RelopLe]");
        return buffer.toString();
    }
}
