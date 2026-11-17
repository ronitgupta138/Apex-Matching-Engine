package com.tradematching.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderExecutionReportTest {
    @Test
    void testExecutionReportState() {
        OrderExecutionReport report = new OrderExecutionReport(
            "ord_1", "INFY", "BUY", 1850.0, 100, 0, System.nanoTime()
        );
        assertTrue(report.isFullyFilled());
        assertEquals("INFY", report.symbol());
        assertEquals(100, report.executedQuantity());

        OrderExecutionReport partial = new OrderExecutionReport(
            "ord_2", "INFY", "BUY", 1850.0, 50, 50, System.nanoTime()
        );
        assertFalse(partial.isFullyFilled());
    }
}
