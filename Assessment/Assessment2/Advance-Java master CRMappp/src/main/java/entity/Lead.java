package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "crm_lead")
public class Lead {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String source;
    private String contactInfo;
    private String status;   // NEW FIELD

    @ManyToOne
    private SalesEmployee employee;

    public Long getId(){ return id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getSource(){ return source; }
    public void setSource(String source){ this.source = source; }

    public String getContactInfo(){ return contactInfo; }
    public void setContactInfo(String contactInfo){ this.contactInfo = contactInfo; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }

    public void setEmployee(SalesEmployee employee){
        this.employee = employee;
    }
}