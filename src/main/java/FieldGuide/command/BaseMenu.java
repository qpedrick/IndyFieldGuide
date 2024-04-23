package FieldGuide.command;

import java.util.Scanner;

// Implements IMenu so child menus can override the displayMenu method
public abstract class BaseMenu implements IMenu {
    protected Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("Welcome to the menu!");
    }
}