# Price-Time Priority (FIFO) Order Matching Engine Invariants

## 1. Matching Invariants
Apex-Matching-Engine enforces strict price-time priority for double auction matching:
- **Price Priority:**
  - Buy (Bid) orders with higher price limits match before lower priced orders.
  - Sell (Ask) orders with lower price limits match before higher priced orders.
- **Time Priority:**
  - At identical price levels, orders are executed strictly in the order of their arrival timestamp (FIFO queue).

## 2. Order Execution Types
- **Limit Orders:** Rest on the order book if no matching counterparty exists at or better than the limit price.
- **Market Orders:** Aggressively sweep opposite book levels until fulfilled or the book is exhausted.
- **Partial Fills:** Remaining unfilled quantities retain their original queue position in the price-level linked list.
