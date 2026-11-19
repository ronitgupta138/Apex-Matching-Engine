package com.tradematching.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IcebergOrderManagerTest {
    @Test
    void testIcebergPeakReplenishment() {
        var iceberg = new IcebergOrderManager.IcebergOrder("ICE_1", 1000L, 200L);
        assertEquals(200L, iceberg.getVisibleQuantity());
        assertEquals(800L, iceberg.getHiddenQuantity());

        // Fill all 200 visible shares -> should trigger auto-replenish of 200 from hidden
        assertTrue(iceberg.executeFill(200L));
        assertEquals(200L, iceberg.getVisibleQuantity());
        assertEquals(600L, iceberg.getHiddenQuantity());
        assertFalse(iceberg.isFullyFilled());
    }
}
