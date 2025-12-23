package org.example.splitwisedemosept24;

import org.example.splitwisedemosept24.commands.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseDemoSept24Application implements CommandLineRunner {

    private CommandExecutor commandExecutor;
    private Scanner scanner = new Scanner(System.in);

    public SplitwiseDemoSept24Application(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to Splitwise Demo Application!");
        while(true) {
            String input = scanner.nextLine();
            commandExecutor.execute(input);
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseDemoSept24Application.class, args);
    }
}
