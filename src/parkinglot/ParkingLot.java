package parkinglot;

import java.time.LocalDate;
import java.util.ArrayList;

import car.Car;

public class ParkingLot {
    private String lotId;
    private String address;
    private int capacity;
	private ArrayList<String> parked;
	private ParkingLotType type;
    
    //Constructor
    public ParkingLot (String id, String a, int cap, String lotType )
    {
    	this.lotId = id;
    	this.address = a;
    	this.capacity = cap;
		this.type = new ParkingLotType(lotType);
		parked = new ArrayList<>();
    }
    //Getters
	public String getLotId(){
		return lotId;
	}
	public String getAddress(){
		return address;
	}
	public int getCapacity(){
		return capacity;
	}
	public String getLotType(){
		return type.getType();
	}
	public ArrayList<String> getParkedCars(){
		return this.parked;
	}
    //Enter the parking lot method
    public int entry(Car car) {
    	LocalDate today = LocalDate.now();
    	if (car.getPermit() == null){
            System.out.println("-----Permit Invalid!-----");
			return 1;   	
		}else if ( today.compareTo(car.getExpiration()) > 0){
    		System.out.println("-----Permit Expired!-----");
			return 2;
		}else if ( this.capacity == 0){
    		System.out.println("-----Parking lot is at full capacity!-----");
			return 3;
    	}else {
    		this.capacity--;
			parked.add(car.getPermit());
    		System.out.println(String.format("%s entered the parking lot %s successfully!", car.getPermit() , getLotId()));
    		System.out.println("Current capacity: " + this.capacity);
			return 0;
    	}
    }
    //Leavng the parking lot method
	public void exit(Car car){
		if (parked.contains(car.getPermit())) {
			this.capacity++;
			parked.remove(car.getPermit());
    		System.out.println(String.format("%s left the parking lot %s successfully!", car.getPermit(),getLotId()));
    		System.out.println("Current capacity: " + this.capacity);
		}else{
			System.out.println("The car is illegally parked");
		}
	}
    //Get info method
    public String toString() {
    	return "Lot ID: " + lotId + "\nLot Address: " + address + "\nLot Capacity: " + capacity + 
				"\nCharges are: " + type.getType() + "\nParked Cars: " + parked;
    }
}
