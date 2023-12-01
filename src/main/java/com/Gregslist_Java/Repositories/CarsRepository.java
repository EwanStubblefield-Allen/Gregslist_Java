package com.Gregslist_Java.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gregslist_Java.Models.Car;

@Repository
public interface CarsRepository extends JpaRepository<Car, String> {
}
