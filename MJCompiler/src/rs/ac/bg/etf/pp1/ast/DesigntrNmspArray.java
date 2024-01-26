// generated with ast extension for cup
// version 0.8
// 26/0/2024 11:48:7


package rs.ac.bg.etf.pp1.ast;

public class DesigntrNmspArray extends Designator {

    private String nmspName;
    private String arrayName;
    private Expr Expr;

    public DesigntrNmspArray (String nmspName, String arrayName, Expr Expr) {
        this.nmspName=nmspName;
        this.arrayName=arrayName;
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public String getNmspName() {
        return nmspName;
    }

    public void setNmspName(String nmspName) {
        this.nmspName=nmspName;
    }

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName=arrayName;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesigntrNmspArray(\n");

        buffer.append(" "+tab+nmspName);
        buffer.append("\n");

        buffer.append(" "+tab+arrayName);
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesigntrNmspArray]");
        return buffer.toString();
    }
}
