package entity;

import jakarta.persistence.*;

@Entity
public class Product {

 @Id @GeneratedValue
 private Long id;
 private String name;
 private double price;

 public void setName(String name){this.name=name;}
 public void setPrice(double price){this.price=price;}
 public double getPrice(){return price;}
}