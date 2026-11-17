package com.tradematching.telemetry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TickToTradeLatencyTrackerTest {
    @Test
    void testLatencyTracking() {
        TickToTradeLatencyTracker tracker = new TickToTradeLatencyTracker();
        tracker.record(1000L, 3000L); // 2000 nanos = 2.0 micros
        tracker.record(5000L, 9000L); // 4000 nanos = 4.0 micros

        assertEquals(2, tracker.getSampleCount());
        assertEquals(3.0, tracker.getAverageLatencyMicros(), 1e-4);
        assertEquals(4.0, tracker.getMaxLatencyMicros(), 1e-4);
    }
}
