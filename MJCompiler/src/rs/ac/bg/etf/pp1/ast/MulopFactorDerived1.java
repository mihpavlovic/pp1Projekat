// generated with ast extension for cup
// version 0.8
// 29/11/2023 22:47:6


package rs.ac.bg.etf.pp1.ast;

public class MulopFactorDerived1 extends MulopFactor {

    private MulopFactor MulopFactor;
    private Mulop Mulop;
    private Factor Factor;

    public MulopFactorDerived1 (MulopFactor MulopFactor, Mulop Mulop, Factor Factor) {
        this.MulopFactor=MulopFactor;
        if(MulopFactor!=null) MulopFactor.setParent(this);
        this.Mulop=Mulop;
        if(Mulop!=null) Mulop.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
    }

    public MulopFactor getMulopFactor() {
        return MulopFactor;
    }

    public void setMulopFactor(MulopFactor MulopFactor) {
        this.MulopFactor=MulopFactor;
    }

    public Mulop getMulop() {
        return Mulop;
    }

    public void setMulop(Mulop Mulop) {
        this.Mulop=Mulop;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulopFactor!=null) MulopFactor.accept(visitor);
        if(Mulop!=null) Mulop.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulopFactor!=null) MulopFactor.traverseTopDown(visitor);
        if(Mulop!=null) Mulop.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulopFactor!=null) MulopFactor.traverseBottomUp(visitor);
        if(Mulop!=null) Mulop.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopFactorDerived1(\n");

        if(MulopFactor!=null)
            buffer.append(MulopFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Mulop!=null)
            buffer.append(Mulop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulopFactorDerived1]");
        return buffer.toString();
    }
}
