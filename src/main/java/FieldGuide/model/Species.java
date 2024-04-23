package FieldGuide.model;

import java.io.Serializable;
import java.util.List;

public abstract class Species implements Serializable {
    String name;
    String info;
    String question;
    List<String> answerOptions;
    String correctAnswer;
    boolean isDiscovered;

    public Species(String name, String info, String question, List<String> answerOptions, String correctAnswer, boolean isDiscovered) {
        this.name = name;
        this.info = info;
        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswer = correctAnswer;
        this.isDiscovered = isDiscovered;
    }

    public String getName() {
        return name;
    }

    public abstract String getInfo();

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isDiscovered() {
        return isDiscovered;
    }

    public void setDiscovered(boolean isDiscovered) {
        this.isDiscovered = isDiscovered;
    }
}