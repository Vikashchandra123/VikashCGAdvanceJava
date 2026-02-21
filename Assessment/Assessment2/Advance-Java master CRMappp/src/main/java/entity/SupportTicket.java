package entity;

import jakarta.persistence.*;

@Entity
public class SupportTicket {

    @Id
    @GeneratedValue
    private Long id;

    private String issueDescription;
    private String status;   // NEW FIELD

    @OneToOne
    private OrderEntity order;

    public void setIssueDescription(String issueDescription){
        this.issueDescription = issueDescription;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setOrder(OrderEntity order){
        this.order = order;
    }
}