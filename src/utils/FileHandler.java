package CarManagement.utils;

import CarManagement.models.Car;
import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String CARS_FILE = "notices.txt";
    private static final String USERS_FILE = "users.txt";

    // Read cars from file
    public static List<Car> readCars() throws IOException {
        List<Car> list = new ArrayList<>();
        File f = new File(CARS_FILE);
        if (!f.exists()) {
            f.createNewFile(); // create if missing
            return list;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    int id = Integer.parseInt(parts[0]);
                    String brand = parts[1];
                    String model = parts[2];
                    String color = parts[3];
                    int year = Integer.parseInt(parts[4]);
                    double price = Double.parseDouble(parts[5]);
                    boolean available = Boolean.parseBoolean(parts[6]);
                    list.add(new Car(id, brand, model, color, year, price, available));
                }
            }
        }
        return list;
    }

    // Overwrite file with list of cars
    public static void writeCars(List<Car> cars) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CARS_FILE))) {
            for (Car c : cars) pw.println(c.toString());
        }
    }

    // Append a car line
    public static void appendCar(Car car) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CARS_FILE, true))) {
            pw.println(car.toString());
        }
    }

    // Simple users file reader: format username,password,role (admin/client)
    public static List<String[]> readUsers() throws IOException {
        List<String[]> users = new ArrayList<>();
        File f = new File(USERS_FILE);
        if (!f.exists()) {
            f.createNewFile();
            return users;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length >= 3) users.add(p);
            }
        }
        return users;
    }
}
