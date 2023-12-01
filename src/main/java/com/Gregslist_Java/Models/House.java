package com.Gregslist_Java.Models;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "houses")
public class House {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @CreationTimestamp
  private Timestamp createdAt;
  @UpdateTimestamp
  private Timestamp updatedAt;
  @Column(nullable = false)
  private Integer bedrooms;
  @Column(nullable = false)
  private Integer bathrooms;
  @Column(nullable = false)
  private Integer year;
  @Column(nullable = false)
  private Double price;
  @Column(nullable = false)
  private String description;
}
