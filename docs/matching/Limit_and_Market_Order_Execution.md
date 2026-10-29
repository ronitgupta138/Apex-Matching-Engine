# Limit and Market Order Execution Rules

## Overview
Architectural specification and design document for the **Apex-Matching-Engine** high-performance Java 21 Loom backend engine.

## Engineering Details
Immediate or cancel partial fills against contra-side limit order book depth.

## Performance Invariants
- Virtual Threads concurrency scaling (`Thread.ofVirtual().start(...)`).
- Zero locks on hot read/query paths (lock-free / CAS / read-copy-update semantics).
- Predictable GC behavior with off-heap or compact memory layout.
