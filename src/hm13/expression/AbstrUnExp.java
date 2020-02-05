package hm13.expression;

public abstract class AbstrUnExp implements Exp {
    protected final Exp first;

    protected AbstrUnExp(final Exp first){
        this.first = first;
    }

    @Override
    public boolean equals(Object object){
        if (object != null && object.getClass() == this.getClass()){
            AbstrBinExp obj = (AbstrBinExp) object;
            return this.first.equals(obj.first);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = prime * result + first.hashCode();
        result = prime * result + getClass().hashCode();
        return result;
    }

}
