# Level 2 (L2) Market Depth Aggregation and Loom Concurrency

## 1. Data Structure Architecture
- **Price Level Indexing:** Navigable, lock-free `ConcurrentSkipListMap` sorted in descending order for Bids and ascending order for Asks.
- **Volume Accumulation:** Price nodes maintain cumulative volume and order count. Updates take $O(\log P)$ where $P$ is the count of distinct active price limits.

## 2. Concurrency Isolation
- Matching loop executes single-threaded per trading symbol to guarantee strict linearizability.
- Market depth snapshot builders and WebSocket fan-out runs asynchronously across Java 21 Loom virtual threads, decoupling client I/O latency from the core matching hot path.
