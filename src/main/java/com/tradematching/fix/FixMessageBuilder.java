package com.tradematching.fix;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * FIX protocol 4.4 tag-value message framing builder.
 */
public class FixMessageBuilder {
    public static final char SOH = '\u0001';

    private final Map<Integer, String> fields = new LinkedHashMap<>();

    public FixMessageBuilder set(int tag, String value) {
        fields.put(tag, value);
        return this;
    }

    public FixMessageBuilder set(int tag, long value) {
        fields.put(tag, String.valueOf(value));
        return this;
    }

    public String build() {
        StringBuilder body = new StringBuilder();
        for (Map.Entry<Integer, String> entry : fields.entrySet()) {
            body.append(entry.getKey()).append('=').append(entry.getValue()).append(SOH);
        }

        // Calculate modulo 256 checksum trailer (tag 10)
        int sum = 0;
        for (int i = 0; i < body.length(); i++) {
            sum += body.charAt(i);
        }
        int checksum = sum % 256;
        body.append("10=").append(String.format("%03d", checksum)).append(SOH);

        return body.toString();
    }
}
