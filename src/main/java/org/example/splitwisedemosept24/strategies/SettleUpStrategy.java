package org.example.splitwisedemosept24.strategies;

import org.example.splitwisedemosept24.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expensesToSettle);
}
