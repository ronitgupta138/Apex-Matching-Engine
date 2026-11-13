# LMAX Disruptor Ring Buffer Single-Writer Sequencing Specification

## 1. Concurrency Architecture
Apex-Matching-Engine replaces multi-threaded lock contention with the single-writer principle powered by an LMAX Disruptor lock-free ring buffer.

## 2. Ring Buffer Structure
- Power-of-two buffer size ($2^{20} = 1,\!048,\!576$ slots) allowing fast bitwise modulo operations (`seq & mask`).
- Pre-allocated `OrderEvent` objects prevent runtime garbage collection churn.
- Cache-line padding (`@Contended` or 64-byte padding bytes) eliminates false sharing across CPU cores.

## 3. Sequencing Invariant
A single core executes matching logic sequentially, achieving deterministic order execution without mutex locks or condition variables.
