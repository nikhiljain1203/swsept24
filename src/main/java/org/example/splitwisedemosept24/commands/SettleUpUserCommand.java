package org.example.splitwisedemosept24.commands;

import org.example.splitwisedemosept24.controllers.SettleUpController;
import org.example.splitwisedemosept24.models.dtos.SettleUpUserRequestDto;
import org.example.splitwisedemosept24.models.dtos.SettleUpUserResponseDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SettleUpUserCommand implements Command {

    private final SettleUpController settleUpController;

    public SettleUpUserCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    //Expected input format: "SettleUpUser <userId>"
    @Override
    public boolean matches(String input) {
        List<String> words = Arrays.asList(input.split(" "));
        if(words.size() != 2) {
            return false;
        }
        return words.get(0).equals("SettleUpUser");
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing SettleUpUser Command with input: " + input);
        List<String> words = Arrays.asList(input.split(" "));

        Long userId = Long.parseLong(words.get(1));

        // Create request DTO
        SettleUpUserRequestDto settleUpUserRequestDto = new SettleUpUserRequestDto();
        settleUpUserRequestDto.setUserId(userId);

        SettleUpUserResponseDto settleUpUserResponseDto
                =  settleUpController.settleUpUser(settleUpUserRequestDto);
        System.out.println("SettleUpUser Response: " + settleUpUserResponseDto);
    }
}
