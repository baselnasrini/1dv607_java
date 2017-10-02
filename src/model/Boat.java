package model;

public class Boat {

    private int ownerPersonalNumber;
    private int length;
    private String type; //TODO make this into types

    public enum BoatType {
        SAILBOAT, MOTORSAILER, KAYAK, OTHER

    }


    public Boat(String type, int length, int ownerPersonalNumber ) {
        this.ownerPersonalNumber = ownerPersonalNumber;
        this.length = length; //length in centimeters
        this.type = type;
    }
}
