package model;

import java.util.ArrayList;

public class helperOptions {
    /*
    HelperOptions is an abstraction, an extra class to use multiple options in the flow of the program
    and show it to the user in an easier way. Now it's only a matter of calling
    a 'addOption' function and put the option details, such as option number '1' and "Create member", as a
    parameter to that function. This takes away many lines of code.

    Notes:
     - not sure about placement in 'Model' package
     - not sure about name of class
     */

    private ArrayList<option> listOfOptions;

    public helperOptions() {
        listOfOptions = new ArrayList<option>(2);
    }


    public ArrayList<option> getList() {
        return listOfOptions;
    }

    public void addOptionToList(int x, String y) {
        option o = new option(x, y);
        this.listOfOptions.add(o);
    }

    public option getOption(int i) {
        return listOfOptions.get(i);
    }

    public void clearList() {
        this.listOfOptions.clear();
    }



    /*
    Below is an inner class for the helperOptions class. This is the actual option. It consists of 2 variables:
     - an option number;
     - an option description.
    These options go into an arraylist, which will be read by the ViewController to determine the text to send to the
    user of the program (via the view).
     */

    public class option {
        int optionNumber;
        String optionDescription;

        option(int optionNumber, String optionDescription) {
            this.optionNumber = optionNumber;
            this.optionDescription = optionDescription;
        }

        public int getInt() {
            return optionNumber;
        }

        public String getString() {
            return optionDescription;
        }
    }
}
