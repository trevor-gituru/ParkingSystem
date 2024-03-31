# Object-Oriented Parking System

## Overview
This Java project implements an Object-Oriented Parking System for a university. The system manages multiple parking lots with different charging mechanisms and provides functionality for customers to register, request parking permits, and incur charges for parking transactions.

## Project Structure
- `src/main/java/` : Contains the Java source code for the project.
    - `address.Address`: Contains the Address class for customers.
    - `car.CarType`: Contains the CarType enum defining types of cars.
    - `car.Car`: Contains the Car class representing customer cars.
    - `money.Money`: Contains classes for handling money-related operations.
    - `parkingcharge.ParkingChargeType`: Contains the ParkingChargeType enum for parking charge transaction status.
    - `parkingcharge.ParkingCharge`: Contains the ParkingCharge class for parking charges.
    - `parkinglot.ParkingLot`: Contains the ParkingLot class representing parking lots.
    - `parkinglot.ParkingLotType`: Contains the ParkingLotType enum defining types of charges for parking lots.
    - `ParkingOffice`: Contains the ParkingOffice class responsible for registering customers, managing their cars, and creating parking charges.

## Class Diagram
The class diagram & sequence diagram for the Parking System is available in the `parkinglot.drawio` PDF file located in the root folder.

## Usage
- Run the `Main.java` file to start the application.
- The ParkingOffice class manages parking lots and customer transactions.
- Customers can register with the ParkingOffice