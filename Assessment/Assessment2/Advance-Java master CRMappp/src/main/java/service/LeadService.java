package service;

import jakarta.persistence.*;
import entity.*;

public class LeadService {

    private EntityManager em;

    public LeadService(EntityManager em){
        this.em = em;
    }

    public void createLead(String name,String source,String contact){

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

            Lead l = new Lead();
            l.setName(name);
            l.setSource(source);
            l.setContactInfo(contact);
            l.setStatus("NEW");   // REQUIRED

            em.persist(l);

            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }
    }

    public void assignLeadToEmployee(Long leadId,Long empId){

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

            Lead lead = em.find(Lead.class,leadId);
            SalesEmployee emp = em.find(SalesEmployee.class,empId);

            lead.setEmployee(emp);

            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }
    }

    public void convertLeadToCustomer(Long leadId){

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

            Lead lead = em.find(Lead.class,leadId);

            if(lead == null){
                System.out.println("Lead not found");
                tx.rollback();
                return;
            }

            Customer c = new Customer();
            c.setName(lead.getName());
            c.setEmail(lead.getContactInfo());
            c.setPhone("NA");

            em.persist(c);

            lead.setStatus("CONVERTED");

            tx.commit();

            System.out.println("Lead converted to customer");

        }catch(Exception e){
            tx.rollback();
        }
    }
}