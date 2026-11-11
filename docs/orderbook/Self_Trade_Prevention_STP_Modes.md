# Self-Trade Prevention (STP) Policies and Invariants

## 1. Supported Policies
- **Cancel Oldest (CO):** Existing resting maker order from same trading account is cancelled.
- **Cancel Newest (CN):** Incoming taker order is cancelled with zero execution.
- **Decrement and Cancel (DC):** Decrements the smaller order quantity and cancels the remainder.
