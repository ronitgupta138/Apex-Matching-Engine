# Financial Information eXchange (FIX) 4.4 Message Framing Specification

## 1. Wire Framing Protocol
Apex-Matching-Engine supports standard FIX 4.4 tag-value message formats over TCP:

```
8=FIX.4.4\x019=122\x0135=D\x0149=TRADER1\x0156=APEX\x0134=101\x0152=20261112-15:30:00\x0111=ORD1001\x0155=RELIANCE\x0154=1\x0138=100\x0144=2450.50\x0140=2\x0110=182\x01
```

## 2. Tag Mapping
- `35=D`: New Order Single
- `54=1`: Buy / `54=2`: Sell
- `44`: Price / `38`: Order Quantity
- `10`: Modulo 256 checksum trailer

## 3. High-Speed Byte Parser
Zero-copy parser processes tags directly from Netty byte buffers without string object allocations.
