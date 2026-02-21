package entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Customer {

 @Id @GeneratedValue
 private Long id;
 private String name;
 private String email;
 private String phone;

 @OneToOne(cascade=CascadeType.ALL)
 private Address address;

 @OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
 private List<OrderEntity> orders=new ArrayList<>();

 public void setName(String name){this.name=name;}
 public void setEmail(String email){this.email=email;}
 public void setPhone(String phone){this.phone=phone;}
 public void setAddress(Address address){this.address=address;}
}