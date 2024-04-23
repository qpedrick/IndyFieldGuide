package FieldGuide.util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntInput() {
        // Get input from user and validate it, red error message if not a number
        while (!scanner.hasNextInt()) {
            System.out.println("\u001B[31mInvalid input. Please enter a number.\u001B[0m");
            scanner.next();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}