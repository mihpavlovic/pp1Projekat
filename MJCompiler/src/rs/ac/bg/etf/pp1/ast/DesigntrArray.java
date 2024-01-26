// generated with ast extension for cup
// version 0.8
// 26/0/2024 21:52:13


package rs.ac.bg.etf.pp1.ast;

public class DesigntrArray extends Designator {

    private ArrName ArrName;
    private Expr Expr;

    public DesigntrArray (ArrName ArrName, Expr Expr) {
        this.ArrName=ArrName;
        if(ArrName!=null) ArrName.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ArrName getArrName() {
        return ArrName;
    }

    public void setArrName(ArrName ArrName) {
        this.ArrName=ArrName;
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
        if(ArrName!=null) ArrName.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrName!=null) ArrName.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrName!=null) ArrName.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesigntrArray(\n");

        if(ArrName!=null)
            buffer.append(ArrName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesigntrArray]");
        return buffer.toString();
    }
}
