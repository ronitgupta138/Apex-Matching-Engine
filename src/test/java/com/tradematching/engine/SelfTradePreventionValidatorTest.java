package com.tradematching.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelfTradePreventionValidatorTest {
    @Test
    void testSelfTradeDetection() {
        assertTrue(SelfTradePreventionValidator.isSelfTrade("TRADER_A", "TRADER_A"));
        assertTrue(SelfTradePreventionValidator.isSelfTrade("trader_a", "TRADER_A")); // case insensitive
        assertFalse(SelfTradePreventionValidator.isSelfTrade("TRADER_A", "TRADER_B"));
        assertFalse(SelfTradePreventionValidator.isSelfTrade(null, "TRADER_B"));
    }
}
