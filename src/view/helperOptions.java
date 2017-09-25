package view;

import java.util.ArrayList;

public class helperOptions {
    private ArrayList<option> list;

    public helperOptions() {
        list = new ArrayList<option>(2);
    }


    public ArrayList<option> getList() {
        return list;
    }

    public void addOptionToList(int x, String y) {
        option o = new option(x, y);
        this.list.add(o);
    }

    public option getOption(int i) {
        return list.get(i);
    }

    public void clearList() {
        this.list.clear();
    }

    public class option {
        int i;
        String j;

        public option(int i, String j) {
            this.i = i;
            this.j = j;
        }

        public int getInt() {
            return i;
        }

        public String getString() {
            return j;
        }
    }
}
