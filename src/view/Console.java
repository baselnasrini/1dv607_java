package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    // Console should just print lines. Thinking of following to functions:
    //helperOptions x = new helperOptions;

    public int getOptions(helperOptions a, String helpText) throws IOException {
        StringBuilder toPrint = new StringBuilder(helpText).append(" \n");
        ArrayList options = a.getList();
        for (int b = 0; b < a.getList().size(); b++) {
            helperOptions.option option = a.getOption(b);
            if (b == a.getList().size() - 1) {
                toPrint.append(String.format("%s) %s", option.getInt(), option.getString()));
            } else {
                toPrint.append(String.format("%s) %s, ", option.getInt(), option.getString()));
            }
        }

        Scanner reader = new Scanner(System.in);
        System.out.println(toPrint.toString());


        return reader.nextInt();
    }

    public String getMessage() {
        return "";
    }
}
