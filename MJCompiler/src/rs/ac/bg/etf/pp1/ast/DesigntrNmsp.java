// generated with ast extension for cup
// version 0.8
// 22/0/2024 23:28:10


package rs.ac.bg.etf.pp1.ast;

public class DesigntrNmsp extends Designator {

    private String nmspName;
    private String name;

    public DesigntrNmsp (String nmspName, String name) {
        this.nmspName=nmspName;
        this.name=name;
    }

    public String getNmspName() {
        return nmspName;
    }

    public void setNmspName(String nmspName) {
        this.nmspName=nmspName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
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
        buffer.append("DesigntrNmsp(\n");

        buffer.append(" "+tab+nmspName);
        buffer.append("\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesigntrNmsp]");
        return buffer.toString();
    }
}
