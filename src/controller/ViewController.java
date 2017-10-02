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

        // This is how easy it is: add the options needed and right below it, create a good looking String
        // message from it.

        helperOptions.clearList();

        helperOptions.addOptionToList(1, "Create member");
        helperOptions.addOptionToList(2, "Retrieve member");
        helperOptions.addOptionToList(3, "Update member");
        helperOptions.addOptionToList(4, "Delete member");
        helperOptions.addOptionToList(5, "List all members");
        helperOptions.addOptionToList(6, "Register boat");
        helperOptions.addOptionToList(7, "Update boat information");
        helperOptions.addOptionToList(8, "Retrieve boat information");
        helperOptions.addOptionToList(9, "Delete a boat");
        helperOptions.addOptionToList(10, "List boats for member");

        createAndSendOptionString(helperOptions.getList(), "Choose an action");

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
                BoatHandler.registerBoat();
                break;
            case 7:
                BoatHandler.updateBoat();
                break;
            case 8:
                BoatHandler.retrieveBoat();
                break;
            case 9:
                BoatHandler.deleteBoat();
                break;
            case 10:
                BoatHandler.listBoats();
                break;
            default:
                c_view.showErrorMessage("That option does not exist");
                whichAction();
        }
    }

    private void createAndSendOptionString(ArrayList al, String initialMessage) {
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
}

/*
 Already done:
 - Abstracted the options away, so that you only have to call a method to add an option to a list.
    After you added all the wanted options, you call another function to create a readable string
    for the user in the console. In short: you only add options and call a method to get the string
    representation
 - Console part: get input for program flow and get text responses from user
 - Did the create member part, but not storing it in XML / JSON.
 - Changed first question.

 To do:
 - Create the diagrams (Wael)
 - Store members and boats in XML / JSON > this is called persistence
 - Make unit tests
 - Figure out how to make .jar
 - Create Member related functions:
    - Retrieve
    - Update
    - Delete
    - List (compact and verbose)
 - Create Boat related functions:
    - Create
    - Retrieve
    - Update
    - Delete
    - List (for a specific member only)
 - Create the complete program flow, make sure the user can do everything in our program using the console.
 */
