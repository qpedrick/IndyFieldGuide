package FieldGuide.model;

import java.util.List;

public class AnimalSpecies extends Species {
    String diet;

    public AnimalSpecies(String name, String info, String question, List<String> answerOptions, String correctAnswer, boolean isDiscovered, String diet) {
        super(name, info, question, answerOptions, correctAnswer, isDiscovered);
        this.diet = diet;
    }

    @Override
    public String getInfo() {
        return this.diet;
    }
}