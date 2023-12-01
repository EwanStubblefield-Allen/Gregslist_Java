package com.Gregslist_Java.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gregslist_Java.Models.House;

@Repository
public interface HousesRepository extends JpaRepository<House, String> {
}
