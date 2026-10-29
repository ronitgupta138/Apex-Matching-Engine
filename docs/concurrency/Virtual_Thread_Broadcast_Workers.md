# Virtual Thread Broadcast Workers

## Overview
Architectural specification and design document for the **Apex-Matching-Engine** high-performance Java 21 Loom backend engine.

## Engineering Details
Distributing trade execution reports and market depth updates via Project Loom.

## Performance Invariants
- Virtual Threads concurrency scaling (`Thread.ofVirtual().start(...)`).
- Zero locks on hot read/query paths (lock-free / CAS / read-copy-update semantics).
- Predictable GC behavior with off-heap or compact memory layout.
