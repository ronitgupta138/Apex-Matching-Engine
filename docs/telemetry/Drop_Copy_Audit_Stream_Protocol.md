# Regulatory Drop Copy FIX Execution Audit Stream

## 1. Protocol
- Separate read-only FIX 4.4 protocol session for risk and regulatory monitoring.
- Transmits ExecutionReport (MsgType 8) messages in real-time with sub-millisecond sequence numbers.
