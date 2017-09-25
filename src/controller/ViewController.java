package controller;

import view.Console;
import view.helperOptions;

import java.io.IOException;

public class ViewController {
    private int answer;
    private helperOptions helperOptions;
    Console c = new Console();

    public void startProgram() {
        answer = 0;
        helperOptions = new helperOptions();

        answer = whichRegister();

        switch (answer) {
            case 1:
                answer = actionsMember();
                break;
            case 2:
                answer = actionsBoat();
                break;
            //default:
            //    System.out.println("That option doesn't exist.");
            //    whichRegister();
        }

        switch (answer) {
            case 1:
                System.out.println("THIS IS CREATE MEMBER.");
        }

    }

    private int whichRegister() {
        helperOptions.clearList();

        helperOptions.addOptionToList(1, "Member");
        helperOptions.addOptionToList(2, "Boat");

        try {
            return c.getOptions(helperOptions, "Which register would you like to use?");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int actionsMember() {
        helperOptions.clearList();

        helperOptions.addOptionToList(1,"Create member");
        helperOptions.addOptionToList(2,"Retrieve member");
        helperOptions.addOptionToList(3,"Update member");
        helperOptions.addOptionToList(4,"Delete member");
        helperOptions.addOptionToList(5,"List all members");

        try {
            return c.getOptions(helperOptions, "Choose an action");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void createMember() {
        String name;
        int idNumber;
        int personalNumber;


    }

    private int actionsBoat() {
        return 0;
    }
}
