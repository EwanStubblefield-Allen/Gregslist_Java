package com.example.Gregslist_Java.Account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
  @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String email;
  private String name;
  private String picture;

  public Account() {
  }

  public Account(Long id, String name, String email, String picture) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.picture = picture;
  }
}