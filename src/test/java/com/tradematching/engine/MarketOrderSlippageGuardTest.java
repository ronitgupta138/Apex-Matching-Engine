package com.tradematching.engine;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class MarketOrderSlippageGuardTest {
    @Test
    void testWithinTolerance() {
        BigDecimal ref = BigDecimal.valueOf(100.0);
        BigDecimal executed = BigDecimal.valueOf(101.5); // 1.5% slippage
        assertTrue(MarketOrderSlippageGuard.isWithinSlippage(executed, ref, 2.0));
    }

    @Test
    void testExceedingTolerance() {
        BigDecimal ref = BigDecimal.valueOf(100.0);
        BigDecimal executed = BigDecimal.valueOf(105.0); // 5% slippage
        assertFalse(MarketOrderSlippageGuard.isWithinSlippage(executed, ref, 2.0));
    }
}
