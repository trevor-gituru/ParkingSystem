import address.Address;
import car.Car;
import car.CarType;
import customer.Customer;
import parkingcharge.ParkingCharge;
import parkinglot.ParkingLot;
import money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; // import the ArrayList class
import java.time.*;

public class ParkingOffice {
    private String name;
    private String address;
    private List<Customer> customers;
    private List<Car> cars;
    private List<ParkingLot> lots;
    private List<ParkingCharge> charges;
    private ArrayList<Money> rates;//This contains discount, hourly, daily and on entry rates
    //To create unique numbers:
    
    //Constructor to initialize Arrays
    public ParkingOffice(String nm, String addr){
      this.name = nm;
      this.address = addr;
      this.customers = new ArrayList<>();
      this.cars = new ArrayList<>();
      this.lots = new ArrayList<>();
      this.charges = new ArrayList<>();  
    }
    //Method to add new Parking Lot into the system
    public ParkingLot register(String address, int capacity, String lotType){
        String lotId = String.format("Lot%d", lots.size());//ID as index in lots array
        ParkingLot mop = new ParkingLot(lotId, address, capacity, lotType);
        lots.add(mop);
        return mop;
    }
    //Method to register new customers into system & return Customer object
    public Customer register(String name, Address address, String phone) {
        String custID = String.format("Cus%d", customers.size());
    	Customer temp = new Customer(custID, name, address, phone);
        this.customers.add(temp);
        return temp;
    }
    //Method to register new Car for the customer into system
    public Car register(Customer c, String license, CarType t) { 
        c.register(license, t);
        Car cCar = c.getCar((-1));
        String permit = String.format("Perm%d", cars.size());
        cCar.setPermit(permit);
        cars.add(cCar);
        return cCar;
    }
    
    //Method to get Customer based on their ID
    public Customer getCustomer(String id) {
        String intString = id.substring(3);
        int index = Integer.parseInt(intString);
    	Customer tem = customers.get(index);
        return tem;
    }
    //Method to get Car based on their permit ID
    public Car getCar(String id) {
        String intString = id.substring(4);
        int index = Integer.parseInt(intString);
    	Car tem = cars.get(index);
        return tem;
    }
    //To set the basic rates
    public void setRates(Money entry, Money hourly, Money daily, Money discountPercent){
        Money[] temp = {entry, hourly, daily, discountPercent};
        rates = new ArrayList<>(Arrays.asList(temp));
    }
    //To view the basic rates
    public String getRates(){
        return String.format("Entry: %d cents \nHourly: %d cents \nDaily: %d cents \nDiscount: %d %%", 
                rates.get(0).getCents(), rates.get(1).getCents(), 
                rates.get(2).getCents(), rates.get(3).getCents() ) ;
    }
    //To create a transaction for customer parking
    public ParkingCharge createCharge(ParkingLot p, Car c){
        int status = p.entry(c);
        //Check whether the car managed to park
        if (status == 0 ) {
            int chargeId = charges.size();
            ParkingCharge temp = new ParkingCharge(chargeId, c.getPermit(), p.getLotId(), "parked");
            charges.add(temp);
            return temp;
        }else{
            return null;
        }
    }
    //To tabulate the total parking transaction after customer left the parking lot
    public Money addCharge(ParkingCharge cha) {
    	if (charges.contains(cha)) {
            ParkingLot lot = lots.get(cha.getLotId());
            Car cur = getCar(cha.getPermitId());
            lot.exit(cur);
            cha.setStatus("Left");
            cha.setAmount(rates, lot.getLotType(), cur.getType().getType());
            System.out.println(cha.getAmount().toString());
            return cha.getAmount();
        }else{
            System.out.println("Invalid Parking Transaction Tocken");
            return new Money(0L);
        }
    }
    //Printers
    public void printCustomers(){
        System.out.println("--------------- Customers:");
        for(Customer element: customers){
            System.out.println(element.toString()+"\n");;
        }
    }
    public void printLots(){
        System.out.println("---------------Parking Lots:");
        for(ParkingLot element: lots){
            System.out.println(element.toString()+"\n");;
        }
    }
    public void printCars(){
        System.out.println("---------------Cars:");
        for(Car element: cars){
            System.out.println(element.toString());;
        }
    }
    public void printCharges(){
        System.out.println("---------------Parking Charges:");
        for(ParkingCharge element: charges){
            System.out.println(element.toString()+"\n");
        }
    }
    
}
