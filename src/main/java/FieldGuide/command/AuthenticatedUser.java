package FieldGuide.command;

import FieldGuide.model.*;
import FieldGuide.util.InputUtil;
import FieldGuide.util.LocationUtil;
import FieldGuide.util.SerializationUtil;

import java.util.List;

public class AuthenticatedUser extends BaseMenu {
    private User user;
    private boolean keepDisplayingMenu = true;
    // Creates and loads locations if they don't exist
    List<Location> locations = LocationUtil.getLocations();

    public AuthenticatedUser(User user) {
        this.user = user;
    }


    @Override
    public void displayMenu() {
        while (keepDisplayingMenu) {
            System.out.println("\u001B[32m+-----------------------------------+\u001B[0m");
            System.out.println("\u001B[32m         Welcome, " + user.getUsername() + "!   \u001B[0m");
            System.out.println("\u001B[32m+-----------------------------------+\u001B[0m");
            System.out.println();
            System.out.println("+-----------------------------------+");
            System.out.println("+    --> 1. Explore Locations       +");
            System.out.println("+    --> 2. View All Locations      +");
            System.out.println("+    --> 3. View Discoveries        +");
            System.out.println("+    --> 4. Change Password         +");
            System.out.println("+    --> 5. Logout                  +");
            System.out.println("+-----------------------------------+");
            System.out.println();
            System.out.println("Choose an option:");
            selectOption();
        }
    }

    public void selectOption() {
        int choice = InputUtil.getIntInput();

        switch (choice) {
            case 1:
                explore();
                break;
            case 2:
                for (Location location: locations) {
                    System.out.println();
                    location.displayDetails();
                }
                break;
            case 3:
                viewDiscoveries();
                break;
            case 4:
                changePassword();
                break;
            case 5:
                System.out.println("Logging out...");
                System.out.println();
                try {
                    SerializationUtil.serializeUser(user, "src/main/resources/data/" + user.getUsername() + ".ser");
                } catch (Exception e) {
                    System.out.println("Error saving user data: " + e.getMessage());
                }
                keepDisplayingMenu = false;
                break;
            default:
                System.out.println("\u001B[31mInvalid selection. Please try again.\u001B[31m");
        }
    }

    public void explore() {
        // Choose random location to explore
        int index = (int) (Math.random() * locations.size());
        Location location = locations.get(index);
        ExploreLocationMenu exploreLocationMenu = new ExploreLocationMenu(location, user);
        exploreLocationMenu.displayMenu();
    }

    public void viewDiscoveries() {
        List<Species> discoveredSpecies = user.getDiscoveredSpecies();
        if (discoveredSpecies.isEmpty()) {
            System.out.println("You have not discovered any species yet.");
            return;
        } else {
            for (Species species : discoveredSpecies) {
                System.out.println("+-----------------------------------+");
                System.out.println("      Name: " + species.getName());
                System.out.println();
                System.out.println(species.getInfo());
                System.out.println("+-----------------------------------+");
                System.out.println();
            }
        }
    }

    public void changePassword() {
        System.out.println("+-----------------------------------+");
        System.out.println("+     Enter your old password:      +");
        System.out.println("+-----------------------------------+");
        String oldPassword = scanner.nextLine();
        if (!user.getPassword().equals(oldPassword)) {
            System.out.println("Incorrect password.");
            return;
        }

        System.out.println("+-----------------------------------+");
        System.out.println("+     Enter your new password:      +");
        System.out.println("+-----------------------------------+");
        String newPassword = scanner.nextLine();
        System.out.println("+-----------------------------------+");
        System.out.println("+     Confirm your new password:    +");
        System.out.println("+-----------------------------------+");
        String confirmPassword = scanner.nextLine();

        if (!newPassword.equals(confirmPassword)) {
            System.out.println("\u001B[31mPasswords do not match.\u001B[0m");
            return;
        }

        user.setPassword(newPassword);

        try {
            // Save user data
            SerializationUtil.serializeUser(user, "src/main/resources/data/" + user.getUsername() + ".ser");
            System.out.println("\u001B[32mPassword changed successfully.\u001B[0m");
        } catch (Exception e) {
            System.out.println("Error changing password: " + e.getMessage());
        }
    }
}