package hm13.expression;

public class Variable implements Exp {
    private final String value;
    
    public Variable(final String value){
        this.value = value;
    }

    public Variable(final char value){
        this.value = Character.toString(value);
    }
    
    public int evaluate(final int value){
        return value;
    }
    
    public double evaluate(final double value){
        return value;
    }
    
    @Override
    public boolean equals(Object object){
        if(object != null && object.getClass().equals(this.getClass())){
            Variable obj = (Variable) object;
            if(this.value.equals(obj.value)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        return this.value.hashCode();
    }
    
    public String toString(){
        return value;
    }
}