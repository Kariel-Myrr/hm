package hm13.expression;

public class Const2 implements Exp {
    private final Number value;


    public Const2(final int value){
        this.value = value;
    }

    public Const2(final double value){
        this.value = value;
    }

    public int evaluate(final int value){
        return this.value.intValue();
    }

    public double evaluate(final double value){
        return this.value.doubleValue();
    }

    @Override
    public int hashCode(){
        return this.value.hashCode();
    }

    @Override
    public boolean equals(Object object){
        if(object != null && object.getClass().equals(this.getClass())){
            Const obj = (Const) object;
            if(this.value.equals(obj.value)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public String toString(){
        return this.value.toString();
    }
}