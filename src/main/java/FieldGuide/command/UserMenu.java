package FieldGuide.command;

import java.io.IOException;

import FieldGuide.model.User;
import FieldGuide.util.*;

public class UserMenu extends BaseMenu {

    public User handleMenu() {
        displayMenu();
        return selectOption();
    }

    @Override
    public void displayMenu() {
        System.out.println("+-----------------------------------+");
        System.out.println("+    --> 1. Login                   +");
        System.out.println("+    --> 2. Sign up                 +");
        System.out.println("+    --> 3. Exit                    +");
        System.out.println("+-----------------------------------+");
        String message = "Please select an option: ";
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public User selectOption() {
        while (true) {
            int choice = InputUtil.getIntInput();
        
            switch (choice) {
                case 1:
                    System.out.println();
                    return login();
                case 2:
                    return signUp();
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("\u001B[31mInvalid selection. Please try again.\u001B[0m");
                    displayMenu();
            }
        }
    }

    private User login() {
        System.out.println("+-----------------------------------+");
        System.out.println("+     Please enter your username:   +");
        System.out.println("+-----------------------------------+");
        String username = scanner.nextLine();
        System.out.println();
        System.out.println("+-----------------------------------+");
        System.out.println("+     Please enter your password:   +");
        System.out.println("+-----------------------------------+");
        String password = scanner.nextLine();
        System.out.println();
        
        try {
            User loggedInUser = SerializationUtil.deserializeUser("src/main/resources/data/" + username + ".ser");
            if (loggedInUser != null && loggedInUser.getPassword().equals(password)) {
                System.out.println();
                return loggedInUser;
            } else {
                System.out.println("Error during login");
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during login: " + e.getMessage());
            User loggedInUser = null;
            return loggedInUser;
        }
    }

    private User signUp() {
        System.out.println("+-----------------------------------+");
        System.out.println("+     Please enter your username:   +");
        System.out.println("+-----------------------------------+");
        String username = scanner.nextLine();
        System.out.println();
        System.out.println("+-----------------------------------+");
        System.out.println("+     Please enter your password:   +");
        System.out.println("+-----------------------------------+");
        String password = scanner.nextLine();
        System.out.println();
        try {
            UserUtil.signup(username, password);
        } catch (Exception e) {
            System.out.println("Error signing up: " + e.getMessage());
            User eUser = null;
            return eUser;
        }
        System.out.println();
        User newUser = new User(username, password);
        return newUser;
    }
}