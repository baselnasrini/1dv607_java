package view;

import model.helperOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    // Console should just print lines.

    // Any logic here is purely UI-related.

    public int getOption(String options) {
        Scanner reader;

        while (true) {
            System.out.println(options);
            reader = new Scanner(System.in);
            String line = reader.nextLine();
            if (line.equals("quit")) {
                System.exit(1);
            } else {
                try {
                    return Integer.valueOf(line);
                } catch (NumberFormatException n) {
                    System.out.println("\nNot a number, please enter the option number\n");
                }
            }
        }
    }

    public String getResponse(String question) {
        Scanner reader = new Scanner(System.in);

        System.out.println(question);

        return reader.nextLine();
    }

    public void showWelcomeMessage() {
        System.out.println("This is a registry for the Yacht Club.");
        System.out.println("To quit this program, type 'quit' and press enter.\n");
    }

    public void showErrorMessage(String text) {
        System.out.println(text);
    }

}
