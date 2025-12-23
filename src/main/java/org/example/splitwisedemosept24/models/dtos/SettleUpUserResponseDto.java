package org.example.splitwisedemosept24.models.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.splitwisedemosept24.models.Expense;
import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private List<Expense> expenses;
}
