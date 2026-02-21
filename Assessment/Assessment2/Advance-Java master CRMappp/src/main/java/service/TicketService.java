package service;

import jakarta.persistence.*;
import entity.*;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em){
        this.em = em;
    }

    public void raiseTicket(Long orderId,String issue){

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

            OrderEntity order = em.find(OrderEntity.class,orderId);

            SupportTicket t = new SupportTicket();
            t.setIssueDescription(issue);
            t.setStatus("OPEN");   // REQUIRED
            t.setOrder(order);

            em.persist(t);

            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }
    }
}