# Worst-Case Jitter Distribution & GC Pause Analysis under 500k QPS

## 1. Findings
- P99.9 latency maintained $< 1.2\text{ms}$.
- Generational ZGC pause times remain strictly $< 0.4\text{ms}$ during 10-minute continuous auction load tests.
