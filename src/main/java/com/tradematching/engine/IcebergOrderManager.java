package com.tradematching.engine;

/**
 * Manages Iceberg order visible peak quantities and replenishments from hidden reserves.
 */
public class IcebergOrderManager {
    public static class IcebergOrder {
        private final String orderId;
        private final long totalQuantity;
        private final long peakSize;
        private long currentVisibleQuantity;
        private long remainingHiddenQuantity;

        public IcebergOrder(String orderId, long totalQuantity, long peakSize) {
            if (peakSize <= 0 || totalQuantity <= 0) {
                throw new IllegalArgumentException("Quantities must be positive");
            }
            this.orderId = orderId;
            this.totalQuantity = totalQuantity;
            this.peakSize = Math.min(peakSize, totalQuantity);
            this.currentVisibleQuantity = this.peakSize;
            this.remainingHiddenQuantity = totalQuantity - this.peakSize;
        }

        public boolean executeFill(long fillQuantity) {
            if (fillQuantity <= 0 || fillQuantity > currentVisibleQuantity) {
                return false;
            }
            currentVisibleQuantity -= fillQuantity;
            if (currentVisibleQuantity == 0 && remainingHiddenQuantity > 0) {
                long replenish = Math.min(peakSize, remainingHiddenQuantity);
                currentVisibleQuantity = replenish;
                remainingHiddenQuantity -= replenish;
            }
            return true;
        }

        public long getVisibleQuantity() { return currentVisibleQuantity; }
        public long getHiddenQuantity() { return remainingHiddenQuantity; }
        public boolean isFullyFilled() { return currentVisibleQuantity == 0 && remainingHiddenQuantity == 0; }
    }
}
