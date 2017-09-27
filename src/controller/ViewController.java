package controller;

import view.Console;
import model.helperOptions;
import model.helperOptions.option;

import java.io.IOException;
import java.util.ArrayList;

public class ViewController {
    private int answer;
    private helperOptions helperOptions;
    Console c_view = new Console();

    public void startProgram() {

        //initialize the beginning of program:

        answer = 0;
        helperOptions = new helperOptions();

        // start with first question
        whichRegister();
    }

    private void whichRegister() {
        helperOptions.clearList();

        helperOptions.addOptionToList(1, "Member");
        helperOptions.addOptionToList(2, "Boat");
        StringBuilder toPrint = new StringBuilder("Which register would you like to use?\n");

        ArrayList<option> optionsList = helperOptions.getList();

        for (int b = 0; b < optionsList.size(); b++) {
            if (b == optionsList.size() - 1) {
                toPrint.append(String.format("%s) %s", optionsList.get(b).getInt(), optionsList.get(b).getString()));
            } else {
                toPrint.append(String.format("%s) %s, ", optionsList.get(b).getInt(), optionsList.get(b).getString()));
            }
        }

        try {
            answer = c_view.getOption(toPrint.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (answer) {
            case 1:
                actionsMember();
                break;
            case 2:
                actionsBoat();
                break;
            default:
               System.out.println("That option doesn't exist.");
               whichRegister();
        }

    }

    private void actionsMember() {
        helperOptions.clearList();

        helperOptions.addOptionToList(1, "Create member");
        helperOptions.addOptionToList(2, "Retrieve member");
        helperOptions.addOptionToList(3, "Update member");
        helperOptions.addOptionToList(4, "Delete member");
        helperOptions.addOptionToList(5, "List all members");
        helperOptions.addOptionToList(6, "Go back");

        StringBuilder toPrint = new StringBuilder("Choose an action:\n");

        ArrayList<option> optionsList = helperOptions.getList();

        for (int b = 0; b < optionsList.size(); b++) {
            if (b == optionsList.size() - 1) {
                toPrint.append(String.format("%s) %s", optionsList.get(b).getInt(), optionsList.get(b).getString()));
            } else {
                toPrint.append(String.format("%s) %s, ", optionsList.get(b).getInt(), optionsList.get(b).getString()));
            }
        }

        try {
            answer = c_view.getOption(toPrint.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (answer) {
            case 1:
                System.out.println("THIS IS CREATE MEMBER.");
                MemberController.createMember();

                break;
            case 6:
                System.out.println("This will go back in 3... 2... 1...");
                whichRegister();
                break;
        }
    }



    private void actionsBoat() {

    }
}
