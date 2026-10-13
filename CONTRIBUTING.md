# Contributing to Apex Matching Engine

Thank you for your interest in contributing to **Apex Matching Engine**! We welcome contributions to in-memory limit order books, FIFO price-time priority matching algorithms, order cancellation logic, and ultra-low-latency financial streaming.

---

## 🛠️ Development Workflow

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/ronitgupta138/apex-matching-engine.git
   cd apex-matching-engine
   ```

2. **Branching Conventions**:
   - `feat/<feature-name>`: Order types (Limit, Market, Stop-Loss), matching rules, or book snapshots
   - `fix/<bug-name>`: Concurrency, fill quantity, or edge-case matching bug fixes
   - `perf/<optimization>`: Zero-allocation order book traversals and cache-line optimizations
   - `docs/<doc-topic>`: Protocol specs and architecture documentation
   - `test/<test-suite>`: Deterministic matching simulation fixtures and stress tests

3. **Running Builds & Tests**:
   Ensure all tests pass before submitting changes:
   ```bash
   mvn clean test
   ```

---

## 📝 Pull Request Guidelines

- **Commit Message Format**: Follow conventional commits (`feat:`, `fix:`, `perf:`, `docs:`, `test:`).
- **FIFO Strict Invariant**: Execution fills must strictly uphold price-time priority invariants without race conditions.
- **Deterministic State**: Given an identical sequence of inbound orders and cancellations, matching engines must emit identical execution trades and resulting depth snapshots.

---

## ⚖️ License
By contributing, you agree that your contributions will be licensed under the project's [MIT License](LICENSE).
