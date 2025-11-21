package CarManagement.models;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String color;
    private int year;
    private double price;
    private boolean available;

    public Car() {}

    public Car(int id, String brand, String model, String color, int year, double price, boolean available) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.available = available;
    }

    // Encapsulation: getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return id + "," + brand + "," + model + "," + color + "," + year + "," + price + "," + available;
    }

    public String prettyPrint() {
        return String.format("ID:%d | %s %s (%d) | Color: %s | Price: %.2f | Available: %s",
                id, brand, model, year, color, price, available ? "Yes" : "No");
    }
}
