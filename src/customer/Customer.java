package customer;


//Importing required classes
import address.Address;
import car.Car;
import car.CarType;

import java.time.LocalDate;
import java.util.ArrayList; // import the ArrayList class


public class Customer {
    private String customerId;
    private String name;
    private Address address;
    private String phoneNumber;
    
    private final ArrayList <Car> car; //to hold number of customers' cars
    
    //Method to get a customer's car
    public Car getCar(int pos) {
    	if (pos >= 0) {
            return car.get(pos);
        }else{
            //-1 means last car customer owns, -2 second last car and so on
            int index = car.size()+pos;
            return car.get(index);
        }
        
    }
    

    //Constructor to initialize customer info
    public Customer( String customerId, String name, Address address, String phoneNumber) {
    	this.customerId = customerId;
    	this.name = name;
    	this.address = address;
    	this.phoneNumber = phoneNumber;
    	this.car = new ArrayList<>();
    }
    
    //Register the customer's car into the system
    public void register( String license, CarType type ) {
    	LocalDate today = LocalDate.now();
    	today = today.plusDays(30);//Every new registered car gets 30 days
    	Car temp = new Car("valid", today, license, type, customerId);
    	this.car.add(temp);
    }
    
    //Get info method
    public String toString() {
    	return "Customer ID: " + customerId + "\nCustomer Name: " + name + "\nCustomer Address: " + address.getAddressInfo()
    	    + "\nCustomer Phone: " + phoneNumber;
    }
    
}
