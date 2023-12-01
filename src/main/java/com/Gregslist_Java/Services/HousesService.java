package com.Gregslist_Java.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Gregslist_Java.Models.House;
import com.Gregslist_Java.Repositories.HousesRepository;

@Service
public class HousesService {
  @Autowired
  private final HousesRepository housesRepository;

  public HousesService(HousesRepository housesRepository) {
    this.housesRepository = housesRepository;
  }

  public List<House> getHouses() {
    return housesRepository.findAll();
  }

  public House getHouseById(String houseId) {
    return housesRepository.findById(houseId).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "[NO HOUSE MATCHES THE ID: " + houseId + "]"));
  }

  public House createHouse(House houseData) {
    return housesRepository.save(houseData);
  }

  public House updateHouse(House houseData) {
    House originalHouse = getHouseById(houseData.getId());
    originalHouse.setBedrooms(houseData.getBedrooms() != null ? houseData.getBedrooms() : originalHouse.getBedrooms());
    originalHouse
        .setBathrooms(houseData.getBathrooms() != null ? houseData.getBathrooms() : originalHouse.getBathrooms());
    originalHouse.setYear(houseData.getYear() != null ? houseData.getYear() : originalHouse.getYear());
    originalHouse.setPrice(houseData.getPrice() != null ? houseData.getPrice() : originalHouse.getPrice());
    originalHouse.setDescription(
        houseData.getDescription() != null ? houseData.getDescription() : originalHouse.getDescription());
    return originalHouse;
  }

  public House removeHouse(String houseId) {
    House houseToDelete = getHouseById(houseId);
    housesRepository.deleteById(houseId);
    return houseToDelete;
  }
}
