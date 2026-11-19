package com.tradematching.engine;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Prevents extreme market order fills by capping price slippage against reference quote.
 */
public class MarketOrderSlippageGuard {
    public static boolean isWithinSlippage(BigDecimal executedPrice, BigDecimal referencePrice, double maxSlippagePercent) {
        if (executedPrice == null || referencePrice == null || referencePrice.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        BigDecimal diff = executedPrice.subtract(referencePrice).abs();
        BigDecimal percentage = diff.divide(referencePrice, 6, RoundingMode.HALF_EVEN).multiply(BigDecimal.valueOf(100.0));

        return percentage.compareTo(BigDecimal.valueOf(maxSlippagePercent)) <= 0;
    }
}
