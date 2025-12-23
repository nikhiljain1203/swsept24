package org.example.splitwisedemosept24.repos;

import org.example.splitwisedemosept24.models.ExpenseUser;
import org.example.splitwisedemosept24.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepo extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findByUser(User user);
}
