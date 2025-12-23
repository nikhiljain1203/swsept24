package org.example.splitwisedemosept24.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    public CommandExecutor(SettleUpUserCommand settleUpUserCommand) {
        commands.add(settleUpUserCommand);
    }

    public void add(Command command) {
        commands.add(command);
    }

    public void remove(Command command) {
        commands.remove(command);
    }

    public void execute(String input) {
        for(Command command : commands) {
            if(command.matches(input)) {
                command.execute(input);
                break;
            }
        }
    }
}
