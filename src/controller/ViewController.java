package controller;

import view.Console;
import model.helperOptions;
import model.helperOptions.option;

import java.util.ArrayList;

public class ViewController {
    private int answer;
    private helperOptions helperOptions;
    private Console c_view = new Console();
    private MemberHandler memberHandler = new MemberHandler();
    private BoatHandler boatHandler = new BoatHandler();

    public void startProgram() {

        //initialize the beginning of program. HelperOptions is a helper class to streamline
        //the use of all the different options in the flow of our program. See class helperOptions.
        helperOptions = new helperOptions();

        // Show introduction text:
        c_view.showWelcomeMessage();

        // start with first question
        whichAction();
    }

    private void whichAction() {
        helperOptions.clearList();

        helperOptions.addOptionToList(1, "Create member");
        helperOptions.addOptionToList(2, "Retrieve member");
        helperOptions.addOptionToList(3, "Update member");
        helperOptions.addOptionToList(4, "Delete member");
        helperOptions.addOptionToList(5, "List all members");
        helperOptions.addOptionToList(6, "Register boat");
        helperOptions.addOptionToList(7, "Update boat info");
        helperOptions.addOptionToList(8, "Get boat info");
        helperOptions.addOptionToList(9, "Delete boat");

        // The following creates the string with the options here above and sends it to the Console.
        // Take a look at the complete function, it is below.

        createStringFromOptionList(helperOptions.getList(), "Choose an action");

        // Because the variable 'answer' is local, we can use the value as set in 'createStringFromOptionList'
        // to compare the answers. Based on the user input, we go to either boat or member.
        // (this can of course be changed as you like.

        switch (answer) {
            case 1:
                memberHandler.createMember();
                break;
            case 2:
                memberHandler.retrieveMember();
                break;
            case 3:
                memberHandler.updateMember();
                break;
            case 4:
                memberHandler.deleteMember();
                break;
            case 5:
                memberHandler.listAllMembers();
                break;
            case 6:
                boatHandler.registerBoat();
                break;
            case 7:
                boatHandler.updateBoatInfo();
                break;
            case 8:
                boatHandler.getBoatInfo();
                break;
            case 9:
                boatHandler.deleteBoatInfo();
                break;
        }
    }

    private void createStringFromOptionList(ArrayList al, String initialMessage) {
        StringBuilder toPrint = new StringBuilder(initialMessage + "\n");
        ArrayList<option> optionsList = helperOptions.getList();

        for (int b = 0; b < optionsList.size(); b++) {
            if (b == optionsList.size() - 1) {
                toPrint.append(String.format("%s) %s", optionsList.get(b).getInt(), optionsList.get(b).getString()));
            } else {
                toPrint.append(String.format("%s) %s, ", optionsList.get(b).getInt(), optionsList.get(b).getString()));
            }
        }

        answer = c_view.getOption(toPrint.toString());
    }

    private void actionsBoat() {

    }
}
