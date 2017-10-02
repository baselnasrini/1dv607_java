package controller;

import model.Boat;
import model.DAO;
import model.Member;
import model.helperOptions;
import view.Console;

import java.util.ArrayList;

class MemberHandler {
    private Console c_view = new Console();
    private DAO dao = new DAO();
    private int answer;
    private helperOptions helperOptions = new helperOptions();

    void createMember() {
        String name;
        int personalNumber;

        name = c_view.getResponse("Name: ");
        personalNumber = Integer.valueOf(c_view.getResponse("\nPersonal number: ")); //WRONG NEEDS BETTER PARSING

        Member newMember = new Member(name, personalNumber);

        helperOptions.clearList();

        helperOptions.addOptionToList(1, "Yes");
        helperOptions.addOptionToList(2, "No");

        while (true) {

            createStringFromOptionList(helperOptions.getList(), "Do you want to add a boat?");

            if (answer == 1) {
                String boatType = c_view.getResponse("Boat type: ");
                int boatLength = Integer.valueOf(c_view.getResponse("Boat length (cm): "));

                Boat boat = new Boat(boatType, boatLength, newMember.getPersonalNumber());

                newMember.addBoat(boat);
            } else
                break;
        }

        dao.writeMemberToFile(newMember);
    }

    void retrieveMember() {
        // Ask user to enter ID
        // Get current list from XML
        // Check for existence.
        // if exists, print
        // if not exists, ask again (or cancel)

        helperOptions.clearList();
        int personalNumber;
        int counter = 0;

        personalNumber = Integer.valueOf(c_view.getResponse("\nPersonal number: ")); //WRONG NEEDS BETTER PARSING

        for (Member a : dao.arrayList) {
            counter++;
            if (a.getPersonalNumber() == personalNumber) {
                c_view.showMessage(a.toString());
                break;
            }

        }

        if (counter == dao.arrayList.size()) {
            c_view.showMessage("There is no member with this personal number! \n");
        }


    }

    void updateMember() {
        // Ask user to enter ID
        // Get current list from XML
        // Check for existence.
        // if exists, ask what to do next (update name or personal number)
        // if not exists, ask again (or cancel)

        helperOptions.clearList();
        int personalNumber;
        int counter = 0;
        Member temp = new Member();
        String newName;
        int newPersonalNumber;


        personalNumber = Integer.valueOf(c_view.getResponse("\nPersonal number: ")); //WRONG NEEDS BETTER PARSING

        for (Member a : dao.arrayList) {
            counter++;
            if (a.getPersonalNumber() == personalNumber) {
                temp.setName(a.getName());
                temp.setPersonalNumber(a.getPersonalNumber());
                break;
            }

        }

        c_view.showMessage(temp.toString());
        c_view.showMessage("What you want to change");
        helperOptions.addOptionToList(1, "Name");
        helperOptions.addOptionToList(2, "Personal Number");
        helperOptions.addOptionToList(3, "Boats");

        if (counter == dao.arrayList.size()) {
            c_view.showMessage("There is no member with this personal number! \n");
        }



    }
    void deleteMember() {
        // Ask user to enter ID
        // Get current list from XML
        // Check for existence.
        // if exists, ask for confirmation
        // if not exists, ask again (or cancel)
    }

    void listAllMembers() {
        // Ask Verbose / Compact list (or cancel)
        // Get current list from XML
        // Print list

    }

    private void createStringFromOptionList(ArrayList al, String initialMessage) { //TODO place this in helperoptions class
        StringBuilder toPrint = new StringBuilder(initialMessage + "\n");
        ArrayList<helperOptions.option> optionsList = helperOptions.getList();

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
