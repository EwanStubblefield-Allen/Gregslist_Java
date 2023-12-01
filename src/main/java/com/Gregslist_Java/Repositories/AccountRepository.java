package com.Gregslist_Java.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Gregslist_Java.Models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
  @Query("SELECT a FROM Account a WHERE a.email = ?1")
  Optional<Account> findByEmail(String email);
}
