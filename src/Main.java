/* Week 4 Assignment
 * ICT-4305-1
 * Nhan Pham
 * University of Denver University College
 * July 10 2022
 * Faculty: Michael Schwartz
 */


//Importing required classes
import java.util.ArrayList;

import address.Address;
import car.Car;
import car.CarType;
import customer.Customer;
import money.Money;
import parkingcharge.ParkingCharge;
import parkinglot.*;


public class Main {

	 public static void main(String[] args) {
            //Parking Office Test Subject
            ParkingOffice alpha = new ParkingOffice("Alpha", "15 Wolf St");

            //Parking Lots Test Subjects & their rates
            ParkingLot pL1 = alpha.register("12 Wall St", 5, "Daily");
            ParkingLot pL2 = alpha.register("99 Empty W", 3, "Hourly");
            Money entry = new Money(588L), hourly = new Money(80L), daily = new Money(800L), 
                  discountPercentage = new Money(20L);
            alpha.setRates(entry, hourly, daily,discountPercentage);

            //Customers Test Subjects
            Address address1 = new Address ("1111 Florida Ave", "Suite 1", "Denver", "CO", "80001");
            Address address2 = new Address ("2222 New York Cir", "Suite 2", "Lakewood", "CO", "80002");
            Address address3 = new Address ("3333 Los Angeles", "Suite 2", "Lakewood", "CO", "80003");
            Customer cust1 = alpha.register("James Bond", address1, "720 111 1111");
            Customer cust2 = alpha.register("Chuck Norris", address2, "555 444 2211");
            Customer cust3 = alpha.register("Christian Bale", address3, "999 666 3333");

            //Register car to their owners
            CarType suv = new CarType("Suv");
            CarType compact = new CarType("Compact");
            Car cust1a = alpha.register(cust1, "AAA-111", compact);
            Car cust1b = alpha.register(cust1, "BBB-222", suv);
            Car cust1c = alpha.register(cust1, "CCC-333", compact);
            Car cust2a = alpha.register(cust2, "DDD-444", compact);
            Car cust2b = alpha.register(cust2, "EEE-555", suv);
            Car cust2c = alpha.register(cust2, "FFF-666", compact);
            Car cust3a = alpha.register(cust3, "GGG-777", compact);
            Car cust3b = alpha.register(cust3, "HHH-888", suv);
            Car cust3c = alpha.register(cust3, "III-999", compact);

            //Print out info
            System.out.println("--------------------Test subjects--------------------");
            alpha.printLots();
            alpha.printCustomers();
            alpha.printCars();
            System.out.println("--------------- Rates:");
            System.out.println(alpha.getRates());

            //Filling up the parking Lot
            System.out.println("---------------Fiiling up the parking lot");
            ParkingCharge cust1aCh = alpha.createCharge(pL1, cust1a);
            ParkingCharge cust1bCh = alpha.createCharge(pL2, cust1b);
            ParkingCharge cust1cCh = alpha.createCharge(pL1, cust1c);
            ParkingCharge cust2aCh = alpha.createCharge(pL2, cust2a);
            ParkingCharge cust2bCh = alpha.createCharge(pL1, cust2b);
            ParkingCharge cust2cCh = alpha.createCharge(pL2, cust2c);
            ParkingCharge cust3aCh = alpha.createCharge(pL1, cust3a);
            ParkingCharge cust3bCh = alpha.createCharge(pL1, cust3b);
            //Printing state of the parking lots
            alpha.printLots();
            //When trying to enter a filled up parking lot
            System.out.println("---------------Entering a full parking lot:");
            ParkingCharge cust3cCh = alpha.createCharge(pL2, cust3c);

            //Emptying the parking lot 
            System.out.println("\n---------------Emptying the parking lot:");
            Money cust1aBal = alpha.addCharge(cust1aCh);
            Money cust1bBal = alpha.addCharge(cust1bCh);
            Money cust1cBal = alpha.addCharge(cust1cCh);
            Money cust2aBal = alpha.addCharge(cust2aCh);
            Money cust2bBal = alpha.addCharge(cust2bCh);
            Money cust2cBal = alpha.addCharge(cust2cCh);
            Money cust3aBal = alpha.addCharge(cust3aCh);
            Money cust3bBal = alpha.addCharge(cust3bCh);
            
             //Printing state of the parking lots
             alpha.printLots();

            //Get all the customer's bills
            alpha.printCharges();
            //Get a customer based on their id
            System.out.println("---------------Searching for customer ID: Cus0");
            System.out.println(alpha.getCustomer("Cus0").toString()); 
         

            



                 
	 }
}
