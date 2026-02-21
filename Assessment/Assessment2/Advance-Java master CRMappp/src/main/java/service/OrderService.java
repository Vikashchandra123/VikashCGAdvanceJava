package service;

import jakarta.persistence.*;
import entity.*;
import java.util.*;
import java.time.LocalDate;

public class OrderService {

 private EntityManager em;

 public OrderService(EntityManager em){this.em=em;}

 public void placeOrder(Long customerId,List<Long> productIds){

  EntityTransaction tx=em.getTransaction();
  tx.begin();

  Customer c=em.find(Customer.class,customerId);

  OrderEntity order=new OrderEntity();
  order.setCustomer(c);
  order.setOrderDate(LocalDate.now());

  double total=0;
  List<Product> plist=new ArrayList<>();

  for(Long id:productIds){
   Product p=em.find(Product.class,id);
   plist.add(p);
   total+=p.getPrice();
  }

  order.setProducts(plist);
  order.setTotalAmount(total);

  em.persist(order);
  tx.commit();
 }
}