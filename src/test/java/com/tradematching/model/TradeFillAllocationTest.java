package com.tradematching.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class TradeFillAllocationTest {
    @Test
    void testAllocationProperties() {
        TradeFillAllocation alloc = new TradeFillAllocation(
            "TR_1", "BUY_101", "SELL_202", BigDecimal.valueOf(500.0), 50L, 0L, 150L
        );
        assertEquals("TR_1", alloc.tradeId());
        assertEquals(50L, alloc.filledQuantity());
        assertEquals(0L, alloc.remainingBuyQuantity());
        assertEquals(150L, alloc.remainingSellQuantity());
    }
}
