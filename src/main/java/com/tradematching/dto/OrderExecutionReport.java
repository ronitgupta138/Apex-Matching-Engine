package com.tradematching.dto;

import java.io.Serializable;

/**
 * Immutable execution trade report receipt.
 */
public record OrderExecutionReport(
    String orderId,
    String symbol,
    String side,
    double executedPrice,
    int executedQuantity,
    int remainingQuantity,
    long timestampNanos
) implements Serializable {
    public boolean isFullyFilled() {
        return remainingQuantity == 0;
    }
}
