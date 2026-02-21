package service;

import jakarta.persistence.*;
import entity.*;

public class CustomerService {

 private EntityManager em;

 public CustomerService(EntityManager em){this.em=em;}

 public void registerCustomer(String name,String email,String phone){
  EntityTransaction tx=em.getTransaction();
  tx.begin();
  Customer c=new Customer();
  c.setName(name);
  c.setEmail(email);
  c.setPhone(phone);
  em.persist(c);
  tx.commit();
 }

 public void addAddressToCustomer(Long id,Address address){
  EntityTransaction tx=em.getTransaction();
  tx.begin();
  Customer c=em.find(Customer.class,id);
  c.setAddress(address);
  em.persist(address);
  tx.commit();
 }
}