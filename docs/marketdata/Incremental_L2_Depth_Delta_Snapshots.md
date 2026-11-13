# Incremental L2 Market Depth Delta Snapshot Dissemination Specification

## 1. Bandwidth Challenge
Transmitting the entire order book (thousands of price levels) on every tick saturates market data feeds.

## 2. Delta Publishing Protocol
- Emits atomic difference events: `(price, quantity_delta, action)` where action is `ADD`, `UPDATE`, or `DELETE`.
- Sequence numbering ($Seq_n$) allows client WebSocket consumers to detect dropped network packets and trigger periodic full-depth resynchronization.

## 3. Top-N Depth Capping
Public WebSocket feeds filter output to top 25 bid and ask levels, reducing feed traffic by 92% while maintaining complete price discovery.
