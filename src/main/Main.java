package CarManagement.main;

import CarManagement.models.*;
import CarManagement.services.*;
import CarManagement.exceptions.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            CarManager manager = new CarManager();

            System.out.println("=== Welcome to CarDealership System ===");
            System.out.print("Username: ");
            String username = sc.nextLine().trim();
            System.out.print("Password: ");
            String password = sc.nextLine().trim();

            String role;
            try {
                role = AuthService.validate(username, password);
            } catch (InvalidCredentialsException ice) {
                System.out.println("Login failed: " + ice.getMessage());
                sc.close();
                return;
            }

            if (role.equalsIgnoreCase("admin")) {
                Admin admin = new Admin(1, "Admin", "User", "admin@example.com", "9999999999", password);
                adminMenu(admin, manager, sc);
            } else {
                Client client = new Client(2, "Buyer", "User", "buyer@example.com", "8888888888", password);
                clientMenu(client, manager, sc);
            }
        } catch (Exception e) {
            System.out.println("Fatal error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    private static void adminMenu(Admin admin, CarManager manager, Scanner sc) {
        int choice = -1;
        do {
            admin.showMenu();
            try {
                System.out.print("Choose: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> { // add
                        System.out.print("ID: "); 
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Brand: "); 
                        String brand = sc.nextLine();

                        System.out.print("Model: "); 
                        String model = sc.nextLine();

                        System.out.print("Color: "); 
                        String color = sc.nextLine();

                        System.out.print("Year: "); 
                        int year = Integer.parseInt(sc.nextLine());

                        System.out.print("Price: "); 
                        double price = Double.parseDouble(sc.nextLine());

                        Car car = new Car(id, brand, model, color, year, price, true);
                        manager.addCar(car);
                        System.out.println("Added.");
                    }
                    case 2 -> { // view
                        List<Car> all = manager.getAllCars();
                        if (all.isEmpty()) System.out.println("No cars.");
                        else {
                            // show pretty prints
                            for (Car c : all) System.out.println(c.prettyPrint());
                            // show arrays conversion example:
                            Car[] arr = manager.toArray(all);
                            // (arr available if needed)
                        }
                    }
                    case 3 -> { // update
                        System.out.print("Enter ID to update: "); 
                        int uid = Integer.parseInt(sc.nextLine());
                        System.out.print("Brand: "); 
                        String brand = sc.nextLine();
                        System.out.print("Model: "); 
                        String model = sc.nextLine();
                        System.out.print("Color: "); 
                        String color = sc.nextLine();
                        System.out.print("Year: "); 
                        int year = Integer.parseInt(sc.nextLine());
                        System.out.print("Price: "); 
                        double price = Double.parseDouble(sc.nextLine());
                        System.out.print("Available (true/false): "); 
                        boolean avail = Boolean.parseBoolean(sc.nextLine());
                        Car updated = new Car(uid, brand, model, color, year, price, avail);
                        manager.updateCar(uid, updated);
                        System.out.println("Updated.");
                    }
                    case 4 -> { // delete
                        System.out.print("Enter ID to delete: "); int did = Integer.parseInt(sc.nextLine());
                        manager.deleteCar(did);
                        System.out.println("Deleted.");
                    }
                    case 5 -> System.out.println("Logging out...");
                    default -> System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number: " + nfe.getMessage());
            } catch (CarNotFoundException cnf) {
                System.out.println("Error: " + cnf.getMessage());
            } catch (IllegalArgumentException iae) {
                System.out.println("Error: " + iae.getMessage());
            } catch (Exception e) {
                System.out.println("I/O error: " + e.getMessage());
            }
        } while (choice != 5);
    }

    private static void clientMenu(Client client, CarManager manager, Scanner sc) {
        int choice = -1;
        do {
            client.showMenu();
            try {
                System.out.print("Choose: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> {
                        List<Car> all = manager.getAllCars();
                        if (all.isEmpty()) System.out.println("No cars.");
                        else all.forEach(c -> System.out.println(c.prettyPrint()));
                    }
                    case 2 -> {
                        System.out.print("Enter brand or model: ");
                        String key = sc.nextLine().trim();
                        List<Car> res = manager.searchByBrandOrModel(key);
                        if (res.isEmpty()) System.out.println("No matches.");
                        else res.forEach(c -> System.out.println(c.prettyPrint()));
                    }
                    case 3 -> System.out.println("Logging out...");
                    default -> System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number: " + nfe.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 3);
    }
}
