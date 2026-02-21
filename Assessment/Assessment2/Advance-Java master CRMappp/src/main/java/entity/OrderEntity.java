package entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name="orders")
public class OrderEntity {

 @Id @GeneratedValue
 private Long id;

 private LocalDate orderDate;
 private double totalAmount;

 @ManyToOne
 private Customer customer;

 @ManyToMany
 private List<Product> products=new ArrayList<>();

 public void setOrderDate(LocalDate d){orderDate=d;}
 public void setTotalAmount(double t){totalAmount=t;}
 public void setCustomer(Customer c){customer=c;}
 public void setProducts(List<Product> p){products=p;}
}