# Double-Auction Matching Engine Sub-Millisecond Latency Profile

## 1. Benchmark Setup
- Synthetic order stream: 1,000,000 orders (70% limit, 20% cancel, 10% market).
- Runtime: OpenJDK 21, AMD Ryzen 5 5600H, Linux 7.0 (BORE scheduler).

## 2. Latency Metrics
- **Throughput:** 420,000 orders matched per second.
- **Latency Distribution:**
  - P50: 0.12ms
  - P95: 0.28ms
  - P99: 0.44ms
  - P99.9: 0.89ms
