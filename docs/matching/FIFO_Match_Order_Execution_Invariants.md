# Price-Time Priority (FIFO) Match Order Execution Invariants

## 1. Execution Priority Hierarchy
Orders are executed strictly according to financial market regulations:
1. **Price Priority:** Aggressive buy orders with higher prices match before lower prices; aggressive sell orders with lower prices match before higher prices.
2. **Time Priority:** For orders at the identical price level, orders entered earlier in time execute before later arrivals.

## 2. Invariant Proof
$$\forall A, B \in \text{Queue}(P): \quad \text{Timestamp}(A) < \text{Timestamp}(B) \implies \text{Executed}(A) < \text{Executed}(B)$$

## 3. Order Modification Invariant
Quantity decreases retain time priority; price changes or quantity increases reset the order timestamp to the end of the price queue.
