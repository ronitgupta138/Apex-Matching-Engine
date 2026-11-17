package com.tradematching.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FixedPointPriceTest {
    @Test
    void testFromDoubleAndPrecision() {
        FixedPointPrice price = FixedPointPrice.fromDouble(2450.50);
        assertEquals(24_505_000L, price.getRawValue());
        assertEquals(2450.50, price.toDouble(), 1e-4);
    }

    @Test
    void testArithmetic() {
        FixedPointPrice a = FixedPointPrice.fromDouble(100.25);
        FixedPointPrice b = FixedPointPrice.fromDouble(50.75);
        FixedPointPrice sum = a.add(b);
        assertEquals(FixedPointPrice.fromDouble(151.00), sum);

        FixedPointPrice diff = a.subtract(b);
        assertEquals(FixedPointPrice.fromDouble(49.50), diff);
    }

    @Test
    void testComparison() {
        FixedPointPrice low = FixedPointPrice.fromDouble(99.0);
        FixedPointPrice high = FixedPointPrice.fromDouble(100.0);
        assertTrue(low.compareTo(high) < 0);
        assertTrue(high.compareTo(low) > 0);
    }
}
