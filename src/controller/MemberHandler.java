package controller;

import model.DAO;
import model.Member;
import view.Console;

class MemberHandler {
    private Console c_view = new Console();
    private DAO dao = new DAO();

    void createMember() {
        String name;
        int idNumber; // Why cant id number be personal Number? PN is unique...
        int personalNumber;

        name = c_view.getResponse("Name: ");
        personalNumber = Integer.valueOf(c_view.getResponse("\nPersonal number: ")); //WRONG NEEDS BETTER PARSING
        idNumber = personalNumber;

        Member newMember = new Member(name, idNumber, personalNumber);
        dao.writeMemberToFile(newMember);
    }

    void retrieveMember() {
        // Ask user to enter ID
        // Get current list from XML
        // Check for existence.
            // if exists, print
            // if not exists, ask again (or cancel)
    }

    void updateMember() {
        // Ask user to enter ID
        // Get current list from XML
        // Check for existence.
        // if exists, ask what to do next (update name or personal number)
        // if not exists, ask again (or cancel)

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
}
