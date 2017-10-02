package model;

public class Boat {

    private int length;
    private BoatType type;

    public enum BoatType {
        SAILBOAT, MOTORSAILER, KAYAK, OTHER

    }


    public Boat(BoatType type, int length) {
        this.length = length; //length in centimeters
        this.type = type;
    }
}
