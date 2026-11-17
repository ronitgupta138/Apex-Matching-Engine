package com.tradematching.validation;

import com.tradematching.dto.OrderRequest;
import com.tradematching.model.OrderSide;
import com.tradematching.model.OrderType;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class OrderValidatorTest {
    @Test
    void testValidOrder() {
        OrderRequest req = new OrderRequest();
        req.setSymbol("TATASTEEL");
        req.setPrice(BigDecimal.valueOf(150.0));
        req.setQuantity(10L);
        req.setSide(OrderSide.BUY);
        req.setType(OrderType.LIMIT);

        assertDoesNotThrow(() -> OrderValidator.validate(req));
    }

    @Test
    void testInvalidQuantityThrows() {
        OrderRequest req = new OrderRequest();
        req.setSymbol("TATASTEEL");
        req.setQuantity(0L);
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validate(req));
    }
}
