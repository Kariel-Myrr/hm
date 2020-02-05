package hm13.expression;

import java.text.DecimalFormat;

public class Const implements Exp {
    protected final double value;
    private static DecimalFormat df = new DecimalFormat("#.#");


    public Const(final int value) {
        this.value = value;
    }

    public Const(final double value) {
        this.value = value;
    }

    public int evaluate(final int value) {
        return (int) this.value;
    }

    public double evaluate(final double value) {
        return this.value;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object.getClass().equals(this.getClass())) {
            Const obj = (Const) object;
            if (this.value == obj.value) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return df.format(value);
    }
}
