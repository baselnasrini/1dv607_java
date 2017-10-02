package model;

public class Boat {

    private int ownerPersonalNumber;
    private int length;
    private String type; //TODO make this into types

    public enum BoatType {
        SAILBOAT, MOTORSAILER, KAYAK, OTHER
    }

    public Boat (){
    	
    }

    public Boat(String type, int length, int ownerPersonalNumber ) {
        this.ownerPersonalNumber = ownerPersonalNumber;
        this.length = length; //length in centimeters
        this.type = type;
    }
    
    public int getLength(){
    	return length ;
    }
    
    public String getType(){
    	return type ;
    }
   
    public void setLength (int length){
    	this.length = length ;
    }
    
    public void setType (String type){
    	this.type = type ;
    }
    
    public void setownerPersonalNumber (int ownerPersonalNumber){
    	this.ownerPersonalNumber = ownerPersonalNumber ;
    }
    
    @Override
    public String toString() {
        return this.type + " , " + this.length;
    }
    
}
