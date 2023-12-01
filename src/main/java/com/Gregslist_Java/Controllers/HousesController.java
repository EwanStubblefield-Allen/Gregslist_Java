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

import com.Gregslist_Java.Models.House;
import com.Gregslist_Java.Services.HousesService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/houses")
public class HousesController {
  @Autowired
  private final HousesService housesService;

  public HousesController(HousesService housesService) {
    this.housesService = housesService;
  }

  @GetMapping
  public List<House> getHouses() {
    return housesService.getHouses();
  }

  @GetMapping("{houseId}")
  public House getHouseById(@PathVariable String houseId) {
    return housesService.getHouseById(houseId);
  }

  @PostMapping
  public House createHouse(@RequestBody House houseData) {
    return housesService.createHouse(houseData);
  }

  @PutMapping("{houseId}")
  @Transactional
  public House updateHouse(@RequestBody House houseData, @PathVariable String houseId) {
    houseData.setId(houseId);
    return housesService.updateHouse(houseData);
  }

  @DeleteMapping("{houseId}")
  public House removeHouse(@PathVariable String houseId) {
    return housesService.removeHouse(houseId);
  }
}
