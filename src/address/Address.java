package address;
public class Address {
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String state;
    private String zipCode;
    
    //Constructor
    public Address( String a1, String a2, String c, String s, String z) {
    	this.streetAddress1 = a1;
    	this.streetAddress2 = a2;
    	this.city = c;
    	this.state = s;
    	this.zipCode = z;
    }
    
    //Get info method
    public String getAddressInfo() {
    	return streetAddress1 + " " + streetAddress2 + ", " + city + " " + state + " " + zipCode; 
    }
    
}
