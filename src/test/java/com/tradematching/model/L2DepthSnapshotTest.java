package com.tradematching.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class L2DepthSnapshotTest {
    @Test
    void testDepthSnapshotImmutability() {
        PriceLevel bid = new PriceLevel(BigDecimal.valueOf(100.0), 500L, 5);
        L2DepthSnapshot snapshot = new L2DepthSnapshot("TCS", List.of(bid), List.of(), System.currentTimeMillis());

        assertEquals("TCS", snapshot.symbol());
        assertEquals(1, snapshot.bids().size());
        assertTrue(snapshot.asks().isEmpty());
    }
}
