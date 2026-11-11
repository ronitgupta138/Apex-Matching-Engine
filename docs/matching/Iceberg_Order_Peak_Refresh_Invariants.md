# Native Iceberg Order Execution and Hidden Balance Invariants

## 1. Mechanics
- **Display Size:** Only the visible peak volume is exposed to the public L2 market depth.
- **Refresh Cycle:** When visible volume is fully executed, a fresh chunk is deducted from hidden reserve and placed at the tail of the respective price queue.
