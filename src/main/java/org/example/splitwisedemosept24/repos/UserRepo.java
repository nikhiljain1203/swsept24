package org.example.splitwisedemosept24.repos;

import org.example.splitwisedemosept24.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
