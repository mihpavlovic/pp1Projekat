// generated with ast extension for cup
// version 0.8
// 29/0/2024 14:42:54


package rs.ac.bg.etf.pp1.ast;

public class FactorChar extends Factor {

    private String ch;

    public FactorChar (String ch) {
        this.ch=ch;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch=ch;
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
        buffer.append("FactorChar(\n");

        buffer.append(" "+tab+ch);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorChar]");
        return buffer.toString();
    }
}
