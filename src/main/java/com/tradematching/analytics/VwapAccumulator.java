package com.tradematching.analytics;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Volume-Weighted Average Price (VWAP) accumulator.
 */
public class VwapAccumulator {
    private BigDecimal totalValue = BigDecimal.ZERO;
    private long totalVolume = 0;

    public synchronized void recordTrade(BigDecimal price, long volume) {
        if (price == null || volume <= 0) {
            return;
        }
        BigDecimal tradeValue = price.multiply(BigDecimal.valueOf(volume));
        totalValue = totalValue.add(tradeValue);
        totalVolume += volume;
    }

    public synchronized BigDecimal calculateVwap() {
        if (totalVolume == 0) {
            return BigDecimal.ZERO;
        }
        return totalValue.divide(BigDecimal.valueOf(totalVolume), 4, RoundingMode.HALF_EVEN);
    }

    public synchronized long getTotalVolume() {
        return totalVolume;
    }
}
