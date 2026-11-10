# Order Cancellation and Atomic Amend Queue Priority Rules

## 1. Cancellation Semantics
- Order lookup via in-memory hash table (`orderId -> OrderNode`) in $O(1)$ time.
- Node is detached from doubly linked FIFO queue at its price level, decrementing cumulative volume.

## 2. Atomic Amend (Cancel & Replace) Rules
- **Volume Reduction:** Amending an existing order to a smaller volume preserves its original time priority in the queue.
- **Price Change or Volume Increase:** Any change to price or increase in quantity forfeits time priority, moving the order to the tail of the respective price queue.
