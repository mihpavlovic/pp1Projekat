// generated with ast extension for cup
// version 0.8
// 29/11/2023 22:47:6


package rs.ac.bg.etf.pp1.ast;

public class MoreVarDeclsDerived3 extends MoreVarDecls {

    public MoreVarDeclsDerived3 () {
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
        buffer.append("MoreVarDeclsDerived3(\n");

        buffer.append(tab);
        buffer.append(") [MoreVarDeclsDerived3]");
        return buffer.toString();
    }
}
