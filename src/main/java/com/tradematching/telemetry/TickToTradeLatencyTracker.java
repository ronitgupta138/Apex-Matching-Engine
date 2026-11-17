package com.tradematching.telemetry;

import java.util.concurrent.atomic.AtomicLong;

/**
 * High-resolution tick-to-trade latency recorder using nanosecond precision.
 */
public class TickToTradeLatencyTracker {
    private final AtomicLong sampleCount = new AtomicLong(0);
    private final AtomicLong totalLatencyNanos = new AtomicLong(0);
    private final AtomicLong maxLatencyNanos = new AtomicLong(0);

    public void record(long startNanos, long endNanos) {
        long duration = Math.max(0, endNanos - startNanos);
        sampleCount.incrementAndGet();
        totalLatencyNanos.addAndGet(duration);
        maxLatencyNanos.accumulateAndGet(duration, Math::max);
    }

    public long getSampleCount() {
        return sampleCount.get();
    }

    public double getAverageLatencyMicros() {
        long count = sampleCount.get();
        if (count == 0) return 0.0;
        return (totalLatencyNanos.get() / (double) count) / 1000.0;
    }

    public double getMaxLatencyMicros() {
        return maxLatencyNanos.get() / 1000.0;
    }
}
