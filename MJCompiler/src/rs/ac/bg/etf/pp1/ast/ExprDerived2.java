// generated with ast extension for cup
// version 0.8
// 29/11/2023 22:47:6


package rs.ac.bg.etf.pp1.ast;

public class ExprDerived2 extends Expr {

    private Term Term;
    private AddopTerm AddopTerm;

    public ExprDerived2 (Term Term, AddopTerm AddopTerm) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.AddopTerm=AddopTerm;
        if(AddopTerm!=null) AddopTerm.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public AddopTerm getAddopTerm() {
        return AddopTerm;
    }

    public void setAddopTerm(AddopTerm AddopTerm) {
        this.AddopTerm=AddopTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(AddopTerm!=null) AddopTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(AddopTerm!=null) AddopTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(AddopTerm!=null) AddopTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprDerived2(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopTerm!=null)
            buffer.append(AddopTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprDerived2]");
        return buffer.toString();
    }
}
