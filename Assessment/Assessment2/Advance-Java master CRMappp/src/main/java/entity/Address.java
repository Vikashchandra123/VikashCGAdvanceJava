package entity;

import jakarta.persistence.*;

@Entity
public class Address {

 @Id @GeneratedValue
 private Long id;
 private String street;
 private String city;
 private String state;
 private String zipCode;

 public Long getId(){return id;}
 public void setStreet(String street){this.street=street;}
 public void setCity(String city){this.city=city;}
 public void setState(String state){this.state=state;}
 public void setZipCode(String zipCode){this.zipCode=zipCode;}
}