package model;

import java.util.ArrayList;

public class Member {
    private String name;
    private int idNumber;
    private int personalNumber;
    private ArrayList<Boat> boats = new ArrayList<Boat>();

    public Member() {
    }

    public Member(String name, int personalNumber) {
        this.name = name;
        this.idNumber = personalNumber;
        this.personalNumber = personalNumber;
    }

    public void addBoat(Boat boat) {
        this.boats.add(boat);
    }

    public ArrayList<Boat> getBoatsRegistry() {
        return this.boats;
    }

    public int getPersonalNumber() {
        return this.personalNumber;
    }

    public String getName(){
        return this.name ;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
        this.idNumber = personalNumber ;
    }

    public void setName(String name){
        this.name = name ;
    }

    public void setBoatsRegistry(ArrayList<Boat> boats){
        this.boats = boats ;
    }

    @Override
    public String toString() {
        return this.name + ",,, " + this.personalNumber;
    }
}