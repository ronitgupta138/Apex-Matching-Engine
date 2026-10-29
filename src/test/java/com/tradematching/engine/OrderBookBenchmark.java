package com.tradematching.engine;

import com.tradematching.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public class OrderBookBenchmark {

    @Test
    void runLatencyAndThroughputBenchmark() {
        OrderBook orderBook = new OrderBook("BTC-USD");
        Random random = new Random(42);

        int warmupOrders = 20_000;
        int benchmarkOrders = 100_000;

        System.out.println("==========================================================");
        System.out.println("🚀 Apex Matching Engine Benchmark — OrderBook Latency & Throughput");
        System.out.println("==========================================================");
        System.out.println("JVM Vendor & Version : " + System.getProperty("java.vm.vendor") + " " + System.getProperty("java.version"));
        System.out.println("Host Architecture    : " + System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") " + Runtime.getRuntime().availableProcessors() + " Cores");
        System.out.println("Warmup Iterations    : " + warmupOrders);
        System.out.println("Benchmark Orders     : " + benchmarkOrders);
        System.out.println("----------------------------------------------------------");

        // 1. Warmup
        for (int i = 0; i < warmupOrders; i++) {
            BigDecimal price = BigDecimal.valueOf(60000 + (random.nextInt(200) - 100));
            OrderSide side = (i % 2 == 0) ? OrderSide.BUY : OrderSide.SELL;
            Order order = new Order("BTC-USD", "WARMUP-" + i, side, OrderType.LIMIT, price, 5);
            orderBook.processOrder(order);
        }

        // Fresh book for real measurement
        orderBook = new OrderBook("BTC-USD");
        long[] latenciesNs = new long[benchmarkOrders];

        long startTimeNs = System.nanoTime();

        for (int i = 0; i < benchmarkOrders; i++) {
            BigDecimal price = BigDecimal.valueOf(60000 + (random.nextInt(100) - 50));
            OrderSide side = (i % 2 == 0) ? OrderSide.BUY : OrderSide.SELL;
            Order order = new Order("BTC-USD", "TRADER-" + (i % 500), side, OrderType.LIMIT, price, 1 + random.nextInt(10));

            long t0 = System.nanoTime();
            orderBook.processOrder(order);
            long t1 = System.nanoTime();

            latenciesNs[i] = (t1 - t0);
        }

        long totalDurationNs = System.nanoTime() - startTimeNs;
        double totalSeconds = totalDurationNs / 1_000_000_000.0;
        double throughputOpsSec = benchmarkOrders / totalSeconds;

        Arrays.sort(latenciesNs);

        double p50Us = latenciesNs[(int) (benchmarkOrders * 0.50)] / 1000.0;
        double p90Us = latenciesNs[(int) (benchmarkOrders * 0.90)] / 1000.0;
        double p99Us = latenciesNs[(int) (benchmarkOrders * 0.99)] / 1000.0;
        double p999Us = latenciesNs[(int) (benchmarkOrders * 0.999)] / 1000.0;
        double minUs = latenciesNs[0] / 1000.0;
        double maxUs = latenciesNs[benchmarkOrders - 1] / 1000.0;

        long sumNs = 0;
        for (long l : latenciesNs) sumNs += l;
        double meanUs = (sumNs / (double) benchmarkOrders) / 1000.0;

        System.out.printf("Total Elapsed Time : %.3f ms (%.3f s)%n", totalDurationNs / 1_000_000.0, totalSeconds);
        System.out.printf("Sustained Throughput: %,.0f orders/sec%n", throughputOpsSec);
        System.out.println("----------------------------------------------------------");
        System.out.println("📊 Latency Percentiles (Microseconds):");
        System.out.printf("  Min Latency       : %8.3f µs%n", minUs);
        System.out.printf("  Mean Latency      : %8.3f µs%n", meanUs);
        System.out.printf("  Median (p50)      : %8.3f µs%n", p50Us);
        System.out.printf("  p90 Latency       : %8.3f µs%n", p90Us);
        System.out.printf("  p99 Latency       : %8.3f µs%n", p99Us);
        System.out.printf("  p99.9 Latency     : %8.3f µs%n", p999Us);
        System.out.printf("  Max Latency       : %8.3f µs%n", maxUs);
        System.out.println("==========================================================");
    }
}
