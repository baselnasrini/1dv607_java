package controller;

import model.Member;
import view.Console;

class MemberController {
    private static Console c_view = new Console();

    static void createMember() {
        String name;
        int idNumber = 0; // Why cant id number be personal Number? PN is unique...
        int personalNumber;

        name = c_view.getResponse("Name: ");
        personalNumber = Integer.valueOf(c_view.getResponse("\nPersonal number: ")); //WRONG NEEDS BETTER PARSING

        // NEED A WAY TO STORE A LASTID. Maybe from xml? Need to see how 1DV600 did this.

        Member newMember = new Member(name, idNumber, personalNumber);
        System.out.println(newMember.toString());

    }

    static void retrieveMember() {
        // Ask user to enter ID
        // Get current list from XML
        // Check for existence.
            // if exists, print
            // if not exists, ask again (or cancel)
    }

    static void updateMember() {
        // Ask user to enter ID
        // Get current list from XML
        // Check for existence.
        // if exists, ask what to do next (update name or personal number)
        // if not exists, ask again (or cancel)

    }
    static void deleteMember() {
        // Ask user to enter ID
        // Get current list from XML
        // Check for existence.
        // if exists, ask for confirmation
        // if not exists, ask again (or cancel)
    }

    static void listAllMembers() {
        // Ask Verbose / Compact list (or cancel)
        // Get current list from XML
        // Print list

    }
}
