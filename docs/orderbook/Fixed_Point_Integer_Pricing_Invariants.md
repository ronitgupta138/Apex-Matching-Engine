# Fixed-Point Integer Pricing & Precision Hazard Mitigation Specification

## 1. IEEE 754 Floating-Point Hazards
Binary floating-point arithmetic (`double`, `float`) exhibits binary representation errors (e.g. $0.1 + 0.2 \neq 0.3$) that are illegal in financial accounting and order book matching.

## 2. Fixed-Point Representation
All financial prices are modeled as 64-bit signed integers with a fixed scale factor of $10^4$:

$$\text{Price}_{\text{int}} = \text{round}(\text{Price}_{\text{decimal}} \cdot 10000)$$

- Example: `2450.50` $\to$ `24505000L`
- Quantity modeled as integer lots (e.g. 1 share).

## 3. Mathematical Operations
Multiplications and divisions incorporate explicit truncation and rounding invariant checks, eliminating penny-rounding discrepancies.
