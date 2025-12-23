package org.example.splitwisedemosept24.services;

import org.example.splitwisedemosept24.models.Expense;
import org.example.splitwisedemosept24.models.ExpenseUser;
import org.example.splitwisedemosept24.models.User;
import org.example.splitwisedemosept24.repos.ExpenseUserRepo;
import org.example.splitwisedemosept24.repos.UserRepo;
import org.example.splitwisedemosept24.strategies.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private final UserRepo userRepo;
    private final ExpenseUserRepo expenseUserRepo;
    private final SettleUpStrategy settleUpStrategy;

    public SettleUpService(UserRepo userRepo,
                           ExpenseUserRepo expenseUserRepo,
                           SettleUpStrategy settleUpStrategy) {
        this.userRepo = userRepo;
        this.expenseUserRepo = expenseUserRepo;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Expense> settleUpUser(Long userId) {
        // Implementation goes here
        //1. Fetch User for the userId
        //2. Fetch all ExpenseUser entries for the User
        //3. From ExpenseUser entries, get all Expenses
        //4. Apply SettleUpStrategy to get the list of settlement expenses
        //5. Return the list of settlement expenses where the user is involved

        Optional<User> userOptional = userRepo.findById(userId);
        if(userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = userOptional.get();

        List<ExpenseUser> expenseUsers = expenseUserRepo.findByUser(user);

        List<Expense> expenses = new LinkedList<>();
        for(ExpenseUser expenseUser : expenseUsers) {
            expenses.add(expenseUser.getExpense());
        }

        List<Expense> expensesToBeSettled = settleUpStrategy.settleUp(expenses);

        List<Expense> expensesToReturn = new ArrayList<>();
        for(Expense expense : expensesToBeSettled) {
            for(ExpenseUser expenseUser : expense.getExpenseUsers()) {
                if(expenseUser.getUser().getId().equals(userId)) {
                    expensesToReturn.add(expense);
                    break;
                }
            }
        }
        return expensesToReturn;
    }
}
