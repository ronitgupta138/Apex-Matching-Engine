package com.tradematching.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Immutable partial fill allocation status record.
 */
public record TradeFillAllocation(
    String tradeId,
    String buyOrderId,
    String sellOrderId,
    BigDecimal price,
    long filledQuantity,
    long remainingBuyQuantity,
    long remainingSellQuantity
) implements Serializable {}
