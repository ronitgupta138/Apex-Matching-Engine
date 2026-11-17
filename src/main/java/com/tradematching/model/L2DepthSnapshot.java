package com.tradematching.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Level 2 market depth aggregated snapshot.
 */
public record L2DepthSnapshot(
    String symbol,
    List<PriceLevel> bids,
    List<PriceLevel> asks,
    long timestamp
) implements Serializable {
    public L2DepthSnapshot {
        bids = (bids != null) ? List.copyOf(bids) : Collections.emptyList();
        asks = (asks != null) ? List.copyOf(asks) : Collections.emptyList();
    }
}
