// generated with ast extension for cup
// version 0.8
// 29/11/2023 22:47:6


package rs.ac.bg.etf.pp1.ast;

public class ProgramDerived1 extends Program {

    private NamespList NamespList;
    private Declarations Declarations;
    private MethodDeclList MethodDeclList;

    public ProgramDerived1 (NamespList NamespList, Declarations Declarations, MethodDeclList MethodDeclList) {
        this.NamespList=NamespList;
        if(NamespList!=null) NamespList.setParent(this);
        this.Declarations=Declarations;
        if(Declarations!=null) Declarations.setParent(this);
        this.MethodDeclList=MethodDeclList;
        if(MethodDeclList!=null) MethodDeclList.setParent(this);
    }

    public NamespList getNamespList() {
        return NamespList;
    }

    public void setNamespList(NamespList NamespList) {
        this.NamespList=NamespList;
    }

    public Declarations getDeclarations() {
        return Declarations;
    }

    public void setDeclarations(Declarations Declarations) {
        this.Declarations=Declarations;
    }

    public MethodDeclList getMethodDeclList() {
        return MethodDeclList;
    }

    public void setMethodDeclList(MethodDeclList MethodDeclList) {
        this.MethodDeclList=MethodDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NamespList!=null) NamespList.accept(visitor);
        if(Declarations!=null) Declarations.accept(visitor);
        if(MethodDeclList!=null) MethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NamespList!=null) NamespList.traverseTopDown(visitor);
        if(Declarations!=null) Declarations.traverseTopDown(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NamespList!=null) NamespList.traverseBottomUp(visitor);
        if(Declarations!=null) Declarations.traverseBottomUp(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDerived1(\n");

        if(NamespList!=null)
            buffer.append(NamespList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Declarations!=null)
            buffer.append(Declarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclList!=null)
            buffer.append(MethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDerived1]");
        return buffer.toString();
    }
}
