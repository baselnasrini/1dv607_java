package view;

import model.helperOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    // Console should just print lines. Thinking of following to functions:
    //helperOptions x = new helperOptions;

    // Any logic here is purely UI-related.

    public int getOption(String options) throws IOException {
        Scanner reader = new Scanner(System.in);

        System.out.println(options);

        return reader.nextInt();
    }

    public String getResponse(String question) {
        Scanner reader = new Scanner(System.in);

        System.out.println(question);

        return reader.nextLine();
    }


}
