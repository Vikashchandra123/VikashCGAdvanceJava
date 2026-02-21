package entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class SalesEmployee {

 @Id @GeneratedValue
 private Long id;
 private String name;
 private String department;

 @OneToMany(mappedBy="employee")
 private List<Lead> leads=new ArrayList<>();
}