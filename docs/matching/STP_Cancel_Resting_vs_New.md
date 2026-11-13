# Self-Trade Prevention (STP) Execution Rules Specification

## 1. Regulatory Purpose
Prevents unintentional self-matching when algorithmic trading clients execute concurrent buy and sell orders from the same legal entity account.

## 2. Supported STP Modes
- **Cancel-Resting (CO):** Cancels the existing order resting on the book and allows the incoming aggressive order to execute.
- **Cancel-New (CN):** Cancels the incoming aggressive order immediately without modifying the order book.
- **Decrement-and-Cancel (DC):** Decrements the matched quantity from both orders; cancels the smaller and leaves remaining balance.

## 3. Audit Logging
Every STP event generates a regulatory compliance audit record in the settlement journal.
