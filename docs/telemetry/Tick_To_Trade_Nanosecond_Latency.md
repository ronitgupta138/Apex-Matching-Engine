# Tick-to-Trade Nanosecond Latency Instrumentation Specification

## 1. Measurement Points
Measures hardware timestamp deltas across the entire matching pipeline:
$$T_0 \text{ (NIC Ingress)} \longrightarrow T_1 \text{ (Disruptor Enqueue)} \longrightarrow T_2 \text{ (Match Complete)} \longrightarrow T_3 \text{ (Outbound Socket)}$$

## 2. TSC Register Access
Uses CPU Time Stamp Counter (`rdtsc`) via Java Panama foreign call for sub-nanosecond timestamp recording.

## 3. Metric Distribution
Exports P50, P90, P99, and P99.9 tick-to-trade latency distributions directly to Grafana dashboards.
