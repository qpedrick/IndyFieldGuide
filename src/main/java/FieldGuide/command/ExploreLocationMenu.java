package FieldGuide.command;

import FieldGuide.model.*;
import FieldGuide.util.InputUtil;
import FieldGuide.util.SerializationUtil;
import FieldGuide.util.SpeciesUtil;

import java.util.List;

public class ExploreLocationMenu extends BaseMenu {
    private Location location;
    private User user;

    public ExploreLocationMenu(Location location, User user) {
        this.location = location;
        this.user = user;
    }

    @Override
    public void displayMenu() {
        boolean continueMenu = true;
        while (continueMenu) {
            System.out.println();
            System.out.println("+-----------------------------------+");
            System.out.println("+       You are now exploring       +");
            System.out.println("      " + location.getName());
            System.out.println("+-----------------------------------+");
            System.out.println("+      What would you like to do?   +");
            System.out.println("+    --> 1. Discover a species      +");
            System.out.println("+    --> 2. Learn more about here   +");
            System.out.println("+    --> 3. Exit                    +");
            System.out.println("+-----------------------------------+");
            System.out.print("Enter your choice: ");
            continueMenu = selectOption();
        }
        return;
    }

    public boolean selectOption() {
        int choice = InputUtil.getIntInput();

        switch (choice) {
            case 1:
                discoverSpecies();
                return true;
            case 2:
                getLocationDetails();
                return true;
            case 3:
                System.out.println("Returning to previous menu...");
                return false;
            default:
                System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
                return true;
        }
    }

    private void discoverSpecies() {
        // Choose a random species from the location
        List<Species> locationSpecies = location.getSpeciesList();
        int index = (int) (Math.random() * locationSpecies.size());
        Species randomSpecies = locationSpecies.get(index);
        boolean discovered = SpeciesUtil.displayQuiz(randomSpecies);
        if (discovered && !user.getDiscoveredSpecies().contains(randomSpecies)) {
            user.addDiscoveredSpecies(randomSpecies);
            System.out.println("Congratulations! You have discovered a new species: " + randomSpecies.getName());

            try {
                SerializationUtil.serializeUser(user, "src/main/resources/data/" + user.getUsername() + ".ser");
            } catch (Exception e) {
                System.out.println("Error while saving data: " + e.getMessage());
            }

        } else {
            System.out.println("You have already discovered this species or your answer was incorrect.");
        }
    }

    private void getLocationDetails() {
        location.displayDetails();
    }
}