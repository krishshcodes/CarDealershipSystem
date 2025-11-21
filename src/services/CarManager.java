package CarManagement.services;

import CarManagement.models.Car;
import CarManagement.exceptions.CarNotFoundException;
import CarManagement.utils.FileHandler;
import java.util.*;
import java.io.*;

public class CarManager implements Manageable {
    private List<Car> cars;

    public CarManager() throws Exception {
        this.cars = FileHandler.readCars();
    }

    @Override
    public void addCar(Car car) throws Exception {
        // simple uniqueness check on id
        for (Car c : cars) {
            if (c.getId() == car.getId()) throw new IllegalArgumentException("Car with same ID exists.");
        }
        cars.add(car);
        FileHandler.appendCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public void updateCar(int id, Car updated) throws CarNotFoundException, Exception {
        boolean found = false;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == id) {
                cars.set(i, updated);
                found = true;
                break;
            }
        }
        if (!found) throw new CarNotFoundException("Car with id " + id + " not found.");
        FileHandler.writeCars(cars);
    }

    @Override
    public void deleteCar(int id) throws CarNotFoundException, Exception {
        boolean removed = cars.removeIf(c -> c.getId() == id);
        if (!removed) throw new CarNotFoundException("Car with id " + id + " not found.");
        FileHandler.writeCars(cars);
    }

    @Override
    public Car[] toArray(List<Car> list) {
        // Demonstrates arrays (requirement)
        Car[] arr = new Car[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }

    // helper search
    public List<Car> searchByBrandOrModel(String keyword) {
        List<Car> res = new ArrayList<>();
        for (Car c : cars) {
            if (c.getBrand().equalsIgnoreCase(keyword) || c.getModel().equalsIgnoreCase(keyword)) res.add(c);
        }
        return res;
    }
}
