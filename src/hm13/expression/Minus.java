package hm13.expression;

public class Minus extends AbstrUnExp {
    public Minus(Exp exp){
        super(exp);
    }

    @Override
    public int evaluate(int value) {
        return -1 * first.evaluate(value);
    }

    @Override
    public double evaluate(double x) {
        return -1 * first.evaluate(x);
    }

    @Override
    public String toString() {
        return "-" + first.toString();
    }
}
