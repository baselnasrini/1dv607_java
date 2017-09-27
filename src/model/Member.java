package model;

public class Member {
    private String name;
    private int idNumber;
    private int personalNumber;

    public Member(String name, int idNumber, int personalNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.personalNumber = personalNumber;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.personalNumber;
    }
}
