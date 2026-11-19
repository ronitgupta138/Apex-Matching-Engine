package com.tradematching.analytics;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class VwapAccumulatorTest {
    @Test
    void testVwapCalculation() {
        VwapAccumulator vwap = new VwapAccumulator();
        // 100 shares @ $10.00 = $1,000
        // 200 shares @ $20.00 = $4,000
        // Total value = $5,000 / 300 shares = $16.6667
        vwap.recordTrade(BigDecimal.valueOf(10.0), 100L);
        vwap.recordTrade(BigDecimal.valueOf(20.0), 200L);

        assertEquals(300L, vwap.getTotalVolume());
        assertEquals(new BigDecimal("16.6667"), vwap.calculateVwap());
    }
}
