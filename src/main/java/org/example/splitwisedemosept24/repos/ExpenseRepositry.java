package org.example.splitwisedemosept24.repos;

import org.example.splitwisedemosept24.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepositry extends JpaRepository<Expense, Long> {
}
