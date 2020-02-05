package hm12.expression;

public abstract class AbstrBinExp implements Exp {

    protected final Exp first;
    protected final Exp second;

    protected AbstrBinExp(final Exp first, final Exp second, final String sign){
        this.first = first;
        this.second = second;
    }
    
    public int evaluate(final int value){
        return evaluate(first.evaluate(value), second.evaluate(value));
    }
    
    public double evaluate(final double value){
        return evaluate(first.evaluate(value), second.evaluate(value));
    }
    
    protected abstract int evaluate(int result1, int result2);
    protected abstract double evaluate(double result1, double result2);
    
    @Override
    public boolean equals(Object object){
        if (object != null && object.getClass() == this.getClass()){
            AbstrBinExp obj = (AbstrBinExp) object;
            return this.first.equals(obj.first)
                && this.second.equals(obj.second);
        } else {
            return false;
        }
    }
    
    
    protected abstract String sign();
    
    @Override
    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = prime * result + first.hashCode();
        result = prime * result + second.hashCode();
        result = prime * result + getClass().hashCode();
        return result;
    }
    
    @Override
    public String toString(){
        return "(" + first.toString() + " " + sign() + " " + second.toString() + ")"; 
    }

}