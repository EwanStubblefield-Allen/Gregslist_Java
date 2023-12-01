package com.Gregslist_Java.Models;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
  @Id
  private String id;
  @CreationTimestamp
  private Timestamp createdAt;
  @UpdateTimestamp
  private Timestamp updatedAt;
  private String email;
  private String name;
  private String picture;
}