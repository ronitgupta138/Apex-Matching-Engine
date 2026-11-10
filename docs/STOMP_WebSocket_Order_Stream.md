# STOMP / WebSocket Market Data Stream Specification

## 1. Subscribed Topics
- `/topic/market-depth/{symbol}`: Periodic (50ms interval) L2 order book top-20 price levels.
- `/topic/trades/{symbol}`: Real-time public execution feed (`trade_id`, `price`, `volume`, `timestamp`, `maker_side`).
- `/user/queue/orders`: Authenticated private execution reports (partial fills, cancellations, rejections).

## 2. Low-Latency Binary Serialization
Payloads formatted using lightweight JSON or FlatBuffers, avoiding large reflection overhead during broadcast.
