package controller;

import model.Member;
import view.Console;

public class MemberController {
    static Console c_view = new Console();

    public static void createMember() {
        String name;
        int idNumber = 0; // Why cant id number be personal Number? PN is unique...
        int personalNumber;

        name = c_view.getResponse("Name: ");
        personalNumber = Integer.valueOf(c_view.getResponse("\nPersonal number: ")); //WRONG NEEDS BETTER PARSING

        // NEED A WAY TO STORE A LASTID. Maybe from xml? Need to see how 1DV600 did this.

        Member newMember = new Member(name, idNumber, personalNumber);
        System.out.println(newMember.toString());

    }
}
