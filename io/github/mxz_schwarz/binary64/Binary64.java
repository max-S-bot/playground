package io.github.mxz_schwarz.binary64;

public class Binary64 {
    private final long VAL_MASK = (1 << 52) - 1;
    private final double VAL_DIV = 1 << 52; 


    private final long bits;

    public Binary64(long bits) {
        this.bits = bits;
    }

    private boolean sign() {
        return bits >> 63 == 1;
    }

    private short exp() {
        return (short) (bits >> 52);
    }

    private long val() {
        return bits & VAL_MASK;
    }

    public Binary64 add(Binary64 other) {
        return null;
    }

    public Binary64 sub(Binary64 other) {
        return null;
    }

    public Binary64 mul(Binary64 other) {
        return null;
    }

    public Binary64 div(Binary64 other) {
        return null;
    }
}