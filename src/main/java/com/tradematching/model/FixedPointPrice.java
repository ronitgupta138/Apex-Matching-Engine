package com.tradematching.model;

import java.io.Serializable;

/**
 * Fixed-point price representation using 64-bit integer scaled by 10^4.
 * Eliminates IEEE-754 binary floating-point representation hazards.
 */
public final class FixedPointPrice implements Serializable, Comparable<FixedPointPrice> {
    public static final long SCALE = 10_000L;

    private final long rawValue;

    public FixedPointPrice(long rawValue) {
        this.rawValue = rawValue;
    }

    public static FixedPointPrice fromDouble(double price) {
        return new FixedPointPrice(Math.round(price * SCALE));
    }

    public double toDouble() {
        return rawValue / (double) SCALE;
    }

    public long getRawValue() {
        return rawValue;
    }

    public FixedPointPrice add(FixedPointPrice other) {
        return new FixedPointPrice(this.rawValue + other.rawValue);
    }

    public FixedPointPrice subtract(FixedPointPrice other) {
        return new FixedPointPrice(this.rawValue - other.rawValue);
    }

    @Override
    public int compareTo(FixedPointPrice other) {
        return Long.compare(this.rawValue, other.rawValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixedPointPrice that = (FixedPointPrice) o;
        return rawValue == that.rawValue;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(rawValue);
    }

    @Override
    public String toString() {
        return String.format("%.4f", toDouble());
    }
}
