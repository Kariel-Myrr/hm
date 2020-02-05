package hm12.expression;


public class Subtract extends AbstrBinExp {

    protected final static String sign = "-";

    public Subtract(final Exp first,final Exp second){
        super(first, second, sign);
    }
    
    @Override
    protected String sign(){
        return sign;
    }
    
    public int evaluate(final int result1, final int result2){
        return result1 - result2;
    }
    
    public double evaluate(final double result1, final double result2){
        return result1 - result2;
    }


}