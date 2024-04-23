package FieldGuide.util;

import FieldGuide.model.Species;
import java.util.List;

public class SpeciesUtil {

    public static boolean displayQuiz(Species species) {
        System.out.println("+-----------------------------------+");
        System.out.println("     You discovered");
        System.out.println("           " + species.getName());
        System.out.println("+-----------------------------------+");
        System.out.println("     Answer this question to discover more about this species");
        System.out.println("     " + species.getQuestion());
        System.out.println("+-----------------------------------+");
        System.out.println("     Answer Options: ");
        List<String> options = species.getAnswerOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println("     --> " + (i + 1) + ". " + options.get(i));
        }
        System.out.println("+-----------------------------------+");
        return handleAnswer(species);
    }

    private static boolean handleAnswer(Species species) {
        int choice = InputUtil.getIntInput();
        boolean isCorrect = species.getAnswerOptions().get(choice - 1).equals(species.getCorrectAnswer());
        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect! Better luck next time!");
        }
        return isCorrect;
    }
}