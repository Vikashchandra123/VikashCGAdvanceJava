package service;

import jakarta.persistence.*;

public class ReportService {

 private EntityManager em;

 public ReportService(EntityManager em){this.em=em;}

 public void getEmployeePerformance(Long empId){

  String jpql="SELECT COUNT(l) FROM Lead l WHERE l.employee.id=:id";

  Long count=em.createQuery(jpql,Long.class)
          .setParameter("id",empId)
          .getSingleResult();

  System.out.println("Leads handled="+count);
 }
}