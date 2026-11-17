package com.tradematching.engine;

/**
 * Self-Trade Prevention (STP) validation policies.
 */
public class SelfTradePreventionValidator {
    public enum StpMode {
        CANCEL_RESTING,
        CANCEL_NEW,
        NONE
    }

    public static boolean isSelfTrade(String restingTraderId, String incomingTraderId) {
        if (restingTraderId == null || incomingTraderId == null) {
            return false;
        }
        return restingTraderId.trim().equalsIgnoreCase(incomingTraderId.trim());
    }
}
