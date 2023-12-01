package com.Gregslist_Java.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gregslist_Java.Models.Car;
import com.Gregslist_Java.Services.CarsService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/cars")
public class CarsController {
  @Autowired
  private final CarsService carsService;

  public CarsController(CarsService carsService) {
    this.carsService = carsService;
  }

  @GetMapping
  public List<Car> getCars() {
    return carsService.getCars();
  }

  @GetMapping("{carId}")
  public Car getCarById(@PathVariable String carId) {
    return carsService.getCarById(carId);
  }

  @PostMapping
  public Car createCar(@RequestBody Car carData) {
    return carsService.createCar(carData);
  }

  @PutMapping("{carId}")
  @Transactional
  public Car updateCar(@RequestBody Car carData, @PathVariable String carId) {
    carData.setId(carId);
    return carsService.updateCar(carData);
  }

  @DeleteMapping("{carId}")
  public Car removeCar(@PathVariable String carId) {
    return carsService.removeCar(carId);
  }
}
