# Double Auction OrderBook Architecture

## Overview
Architectural specification and design document for the **Apex-Matching-Engine** high-performance Java 21 Loom backend engine.

## Engineering Details
Bids descending TreeMap and Asks ascending TreeMap organizing price levels.

## Performance Invariants
- Virtual Threads concurrency scaling (`Thread.ofVirtual().start(...)`).
- Zero locks on hot read/query paths (lock-free / CAS / read-copy-update semantics).
- Predictable GC behavior with off-heap or compact memory layout.
