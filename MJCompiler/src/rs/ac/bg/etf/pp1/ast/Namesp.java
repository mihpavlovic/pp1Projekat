// generated with ast extension for cup
// version 0.8
// 26/0/2024 16:33:3


package rs.ac.bg.etf.pp1.ast;

public class Namesp implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private NamespName NamespName;
    private Declarations Declarations;

    public Namesp (NamespName NamespName, Declarations Declarations) {
        this.NamespName=NamespName;
        if(NamespName!=null) NamespName.setParent(this);
        this.Declarations=Declarations;
        if(Declarations!=null) Declarations.setParent(this);
    }

    public NamespName getNamespName() {
        return NamespName;
    }

    public void setNamespName(NamespName NamespName) {
        this.NamespName=NamespName;
    }

    public Declarations getDeclarations() {
        return Declarations;
    }

    public void setDeclarations(Declarations Declarations) {
        this.Declarations=Declarations;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NamespName!=null) NamespName.accept(visitor);
        if(Declarations!=null) Declarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NamespName!=null) NamespName.traverseTopDown(visitor);
        if(Declarations!=null) Declarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NamespName!=null) NamespName.traverseBottomUp(visitor);
        if(Declarations!=null) Declarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Namesp(\n");

        if(NamespName!=null)
            buffer.append(NamespName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Declarations!=null)
            buffer.append(Declarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Namesp]");
        return buffer.toString();
    }
}
