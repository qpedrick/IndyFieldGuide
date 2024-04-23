package FieldGuide.model;

import java.util.List;

public class LandLocation extends Location {
    String type;

    public LandLocation(String name, String description, List<Species> speciesList) {
        super(name, description, speciesList);
        this.type = "Terrestrial";
    }

    @Override
    public void displayDetails() {
        System.out.println("\u001B[32m+-----------------------------------+");
        System.out.println("Location: " + name);
        System.out.println("Type: " + type);
        System.out.println("Description: " + description);
        System.out.println("+-----------------------------------+\u001B[0m");
        System.out.println("Species: \n");
        for (Species species : speciesList) {
            System.out.println(species.name);
            System.out.println();
        }
        System.out.println("\u001B[32m+-----------------------------------+\u001B[0m");
        System.out.println();
    }
}