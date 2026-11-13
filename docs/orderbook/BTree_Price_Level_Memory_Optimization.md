# B-Tree Price Level Index Memory Footprint Optimization Specification

## 1. Order Book Memory Challenge
High-frequency limit order books (L2/L3) maintain tens of thousands of active price levels. Object-heavy tree representations trigger GC pauses in Java runtimes.

## 2. Compact Int2Object Fixed-Point Tree
- Price levels mapped to primitive integers ($p \cdot 10^4$).
- Custom primitive collection (`FastUtil` / `Agrona`) eliminates boxed `Integer` wrapper overhead.
- Doubly-linked FIFO order queue at each price level uses primitive 64-bit array indices instead of Java reference pointers.

## 3. Allocation Rate
Order insertion and matching on active price levels executes with **zero heap allocations** on the hot path.
