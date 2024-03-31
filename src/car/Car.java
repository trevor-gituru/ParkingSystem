package car;

import java.time.*;

public class Car {
    private String permit;
    private LocalDate expiration;
    private String license;
    private CarType type;
    private String owner; //customer ID
    
    //Constructors
    public Car() {
    	this.permit = null;
    	this.expiration = LocalDate.now();
    	this.license = "123-ABC";
    	type.setType("compact");
    	this.owner = "001";
    }
    public Car( String permit, LocalDate expiration, String license, CarType type, String owner) {
    	setPermit(permit);
    	setExpiration(expiration);
    	setLicense(license);
    	setType(type);
    	setOwner(owner);    		
    }
    //Setters    
    public void setPermit(String st) {
    	this.permit=st;
    }
    public void setExpiration(LocalDate exp) {
    	this.expiration=exp;
    }
    public void setLicense(String lc) {
        this.license = lc;
    }
    public void setType(CarType ty) {
    	this.type = ty;
    }
    public void setOwner(String custId) {
    	this.owner = custId;
    }
    //Getters
    public String getPermit() {
    	return this.permit;
    }
    public LocalDate getExpiration() {
    	return this.expiration;
    }
    public String getLicense() {
    	return this.license;
    }
    public CarType getType() {
    	return this.type;
    }
    public String getOwner() {
    	return this.owner;
    }
    
    //Get info method
    public String toString() {
    	String space = "\n               ";
    	String date = expiration.getMonth() + " " + expiration.getDayOfMonth() + " " + expiration.getYear();
    	return space + "Permit: " + permit + space + "Expiration Date: " + date + space + "License Plate: " 
    			+ license + space + "Car Type: " + type.getType() + space + "Owned by: " + owner;
    }
}
