import vehicleType.Car;
import vehicleType.Motorcycle;
import vehicleType.Truck;
import vehicleType.Vehicle;

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

        System.out.println("To park vehicle - park car/truck/motorcycle vehicleNumber\n" +
                "To unpark vehicle - unpark car/truck/motorcycle vehicleNumber\n" +
                "To show display - show\n" +
                "To exit - exit\n");

        while(true) {
            String command = br.readLine();
            if(command.equals("exit")) return;
            else if(command.equals("show")) parkingLot.displayAvailability();
            else {
                String[] arr = command.split(" ");
                System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
                if(arr[0].equals("park")) {
                    switch(arr[1]) {
                        case "car" :
                            map.put(arr[2], parkingLot.parkVehicle(new Car(arr[2])));
                            break;
                        case "truck" :
                            map.put(arr[2], parkingLot.parkVehicle(new Truck(arr[2])));
                            break;
                        case "motorcycle" :
                            map.put(arr[2], parkingLot.parkVehicle(new Motorcycle(arr[2])));
                            break;
                    }
                } else if(arr[0].equals("unpark")) {
                    switch(arr[1]) {
                        case "car" :
                            parkingLot.unparkVehicle(map.get(arr[2]));
                            break;
                        case "truck" :
                            parkingLot.unparkVehicle(map.get(arr[2]));
                            break;
                        case "motorcycle" :
                            parkingLot.unparkVehicle(map.get(arr[2]));
                            break;
                    }
                    map.remove(arr[2]);
                }
            }
        }
    }
}
