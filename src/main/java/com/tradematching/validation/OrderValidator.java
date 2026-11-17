package com.tradematching.validation;

import com.tradematching.dto.OrderRequest;
import java.math.BigDecimal;

/**
 * Validates incoming order parameters against exchange trading rules.
 */
public class OrderValidator {
    public static void validate(OrderRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("OrderRequest cannot be null");
        }
        if (request.getSymbol() == null || request.getSymbol().trim().isEmpty()) {
            throw new IllegalArgumentException("Symbol is required");
        }
        if (request.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (request.getPrice() != null && request.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
    }
}
