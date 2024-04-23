package FieldGuide.model;

import java.util.List;

public class PlantSpecies extends Species {
    String growthPattern;

    public PlantSpecies(String name, String info, String question, List<String> answerOptions, String correctAnswer, boolean isDiscovered, String growthPattern) {
        super(name, info, question, answerOptions, correctAnswer, isDiscovered);
        this.growthPattern = growthPattern;
    }

    @Override
    public String getInfo() {
        return this.growthPattern;
    }
}