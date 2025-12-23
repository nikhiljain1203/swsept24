package org.example.splitwisedemosept24.strategies;

import org.example.splitwisedemosept24.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Expense> settleUp(List<Expense> expensesToSettle) {
        // Default implementation: return the expenses as is
        return expensesToSettle;
    }
}
