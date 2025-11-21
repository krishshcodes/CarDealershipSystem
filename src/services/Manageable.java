//INTERFACE

package CarManagement.services;

import CarManagement.models.Car;
import CarManagement.exceptions.CarNotFoundException;
import java.util.List;

public interface Manageable {
    void addCar(Car car) throws Exception;
    List<Car> getAllCars() throws Exception;
    void updateCar(int id, Car updated) throws CarNotFoundException, Exception;
    void deleteCar(int id) throws CarNotFoundException, Exception;
    Car[] toArray(List<Car> list); // shows arrays usage
}
