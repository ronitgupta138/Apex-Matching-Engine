package com.tradematching.fix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FixMessageBuilderTest {
    @Test
    void testFixMessageFramingAndChecksum() {
        FixMessageBuilder builder = new FixMessageBuilder();
        builder.set(8, "FIX.4.4")
               .set(35, "D")
               .set(55, "RELIANCE")
               .set(54, "1");
        String msg = builder.build();

        assertTrue(msg.startsWith("8=FIX.4.4\u000135=D\u0001"));
        assertTrue(msg.contains("10="));
        assertTrue(msg.endsWith("\u0001"));
    }
}
