package org.example.splitwisedemosept24.commands;

public interface Command {
    void execute(String input);
    boolean matches(String input);
}
