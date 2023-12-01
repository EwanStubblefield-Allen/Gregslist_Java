package com.Gregslist_Java.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Gregslist_Java.Models.Car;
import com.Gregslist_Java.Repositories.CarsRepository;

@Service
public class CarsService {
  @Autowired
  private final CarsRepository carsRepository;

  public CarsService(CarsRepository carsRepository) {
    this.carsRepository = carsRepository;
  }

  public List<Car> getCars() {
    return carsRepository.findAll();
  }

  public Car getCarById(String carId) {
    return carsRepository.findById(carId)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "[NO CHARACTER MATCHES THE ID: " + carId + "]"));
  }

  public Car createCar(Car carData) {
    return carsRepository.save(carData);
  }

  public Car updateCar(Car carData) {
    Car originalCar = getCarById(carData.getId());
    originalCar.setMake(carData.getMake().length() > 0 ? carData.getMake() : originalCar.getMake());
    originalCar.setModel(carData.getModel().length() > 0 ? carData.getModel() : originalCar.getModel());
    originalCar.setColor(carData.getColor().length() > 0 ? carData.getColor() : originalCar.getColor());
    originalCar.setPrice(carData.getPrice() != null ? carData.getPrice() : originalCar.getPrice());
    return originalCar;
  }

  public Car removeCar(String carId) {
    Car carToDelete = getCarById(carId);
    carsRepository.deleteById(carId);
    return carToDelete;
  }
}
