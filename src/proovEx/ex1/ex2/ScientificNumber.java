package proovEx.ex1.ex2;

public class ScientificNumber extends Number{
    private int mantissa;
    private int exponent;

    public ScientificNumber(int mantissa, int exponent) {
        this.mantissa = mantissa;
        this.exponent = exponent;
    }

    @Override
    public int intValue() {
        return mantissa * Double.valueOf(Math.pow(10, exponent)).intValue();
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

}