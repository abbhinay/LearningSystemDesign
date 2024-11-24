package ParkingLot;

import ParkingLot.Gates.Entrance;
import ParkingLot.Gates.Exit;
import ParkingLot.Gates.ParkingTicket;
import ParkingLot.Payment.CashPayment;
import ParkingLot.Payment.CreditCardPayment;
import ParkingLot.Payment.UpiPayment;
import ParkingLot.vehicleType.Car;
import ParkingLot.vehicleType.Motorcycle;
import ParkingLot.vehicleType.Truck;
import ParkingLot.vehicleType.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ParkingLotController {
    public static void main(String[] args) throws IOException {
        ParkingLot parkingLot = ParkingLot.getInstance();

        Admin admin = new Admin();
        admin.initializeParkingLot();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, ParkingTicket> map = new HashMap<>();

        System.out.println("To park vehicle - entrance1/entrance2 park car/truck/motorcycle vehicleNumber\n" +
                "To unpark vehicle - exit1/exit2 unpark car/truck/motorcycle vehicleNumber\n" +
                "To show display - show\n" +
                "To exit - exit\n");

        while(true) {
            String command = br.readLine();
            if(command.equals("exit")) return;
            else if(command.equals("show")) parkingLot.displayAvailability();
            else {
                String[] arr = command.split(" ");
                if(arr.length!=4) {
                    System.out.println("wrong command");
                    continue;
                }
                if(arr[1].equals("park")) {
                    Entrance entrance = parkingLot.getEntrance(arr[0]);
                    if(entrance==null) continue;
                    switch(arr[2]) {
                        case "car" :
                            Vehicle car = new Car(arr[3]);
                            map.put(arr[3], entrance.getTicket(car));
                            parkingLot.parkVehicle(car);
                            break;
                        case "truck" :
                            Vehicle truck = new Truck(arr[3]);
                            map.put(arr[3], entrance.getTicket(truck));
                            parkingLot.parkVehicle(truck);
                            break;
                        case "motorcycle" :
                            Vehicle motorcycle = new Motorcycle(arr[3]);
                            map.put(arr[3], entrance.getTicket(motorcycle));
                            parkingLot.parkVehicle(motorcycle);
                            break;
                    }
                }
                else if(arr[1].equals("unpark")) {
                    Exit exit = parkingLot.getExit(arr[0]);
                    if(exit==null) continue;
                    if(!map.containsKey(arr[3])) {
                        System.out.println("wrong command");
                        continue;
                    }
                    ParkingTicket parkingTicket = map.get(arr[3]);
                    parkingLot.unparkVehicle(parkingTicket);
                    while(true) {
                        System.out.println("Please select payment methods : cash, upi, credit card");
                        command = br.readLine();
                        switch(command) {
                            case "cash" :
                                exit.setPaymentMethod(parkingTicket, new CashPayment());
                                break;
                            case "upi" :
                                System.out.println("enter upi id");
                                command = br.readLine();
                                exit.setPaymentMethod(parkingTicket, new UpiPayment(command));
                                break;
                            case "credit card" :
                                System.out.println("enter name card number cvv expiry date");
                                String[] cardDetails = br.readLine().split(" ");
                                if(cardDetails.length!=4) continue;
                                exit.setPaymentMethod(parkingTicket, new CreditCardPayment(cardDetails[0], cardDetails[1], Integer.parseInt(cardDetails[2]), cardDetails[3]));
                                break;
                            default:
                                continue;
                        }
                        break;
                    }
                    exit.validateTicket(parkingTicket);
                    map.remove(arr[3]);
                }
            }
        }
    }
}
