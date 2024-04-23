package FieldGuide.model;

import java.io.Serializable;
import java.util.List;

public abstract class Location implements Serializable {
    String name;
    String description;
    List<Species> speciesList;

    public Location(String name, String description, List<Species> speciesList) {
        this.name = name;
        this.description = description;
        this.speciesList = speciesList;
    }

    public abstract void displayDetails();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Species> getSpeciesList() {
        return speciesList;
    }
}