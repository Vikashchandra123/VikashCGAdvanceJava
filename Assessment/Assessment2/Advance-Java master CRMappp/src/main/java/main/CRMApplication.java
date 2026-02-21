package main;

import jakarta.persistence.*;
import java.util.*;
import entity.*;
import service.*;

public class CRMApplication {

    public static void main(String[] args){

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("crmPU");

        EntityManager em = emf.createEntityManager();

        CustomerService customerService = new CustomerService(em);
        LeadService leadService = new LeadService(em);
        ProductService productService = new ProductService(em);
        OrderService orderService = new OrderService(em);
        TicketService ticketService = new TicketService(em);
        ReportService reportService = new ReportService(em);

        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n1.Register Customer");
            System.out.println("2.Add Address");
            System.out.println("3.Create Lead");
            System.out.println("4.Assign Lead");
            System.out.println("5.Convert Lead");
            System.out.println("6.Add Product");
            System.out.println("7.Place Order");
            System.out.println("8.Raise Ticket");
            System.out.println("9.Employee Performance");
            System.out.println("10.Exit");

            int ch = sc.nextInt();
            sc.nextLine(); // 🔥 clear buffer

            switch(ch){

                // ===============================
                case 1: // Register Customer
                    System.out.println("Enter Name:");
                    String cname = sc.nextLine();

                    System.out.println("Enter Email:");
                    String cemail = sc.nextLine();

                    System.out.println("Enter Phone:");
                    String cphone = sc.nextLine();

                    customerService.registerCustomer(cname,cemail,cphone);
                    System.out.println("Customer Added.");
                    break;

                // ===============================
                case 2: // Add Address
                    System.out.println("Enter Customer ID:");
                    Long custId = sc.nextLong();
                    sc.nextLine();

                    Address a = new Address();

                    System.out.println("Street:");
                    a.setStreet(sc.nextLine());

                    System.out.println("City:");
                    a.setCity(sc.nextLine());

                    System.out.println("State:");
                    a.setState(sc.nextLine());

                    System.out.println("ZipCode:");
                    a.setZipCode(sc.nextLine());

                    customerService.addAddressToCustomer(custId,a);
                    System.out.println("Address Added.");
                    break;

                // ===============================
                case 3: // Create Lead
                    System.out.println("Lead Name:");
                    String lname = sc.nextLine();

                    System.out.println("Lead Source:");
                    String lsource = sc.nextLine();

                    System.out.println("Contact Info:");
                    String lcontact = sc.nextLine();

                    leadService.createLead(lname,lsource,lcontact);
                    System.out.println("Lead Created.");
                    break;

                // ===============================
                case 4: // Assign Lead
                    System.out.println("Enter Lead ID:");
                    Long leadId = sc.nextLong();

                    System.out.println("Enter Employee ID:");
                    Long empId = sc.nextLong();
                    sc.nextLine();

                    leadService.assignLeadToEmployee(leadId,empId);
                    System.out.println("Lead Assigned.");
                    break;

                // ===============================
                case 5: // Convert Lead
                    System.out.println("Enter Lead ID:");
                    Long convId = sc.nextLong();
                    sc.nextLine();

                    leadService.convertLeadToCustomer(convId);
                    break;

                // ===============================
                case 6: // Add Product
                    System.out.println("Product Name:");
                    String pname = sc.nextLine();

                    System.out.println("Price:");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    productService.addProduct(pname,price);
                    System.out.println("Product Added.");
                    break;

                // ===============================
                case 7: // Place Order
                    System.out.println("Customer ID:");
                    Long orderCustId = sc.nextLong();
                    sc.nextLine();

                    System.out.println("Enter Product IDs (comma separated e.g. 1,2,3):");
                    String line = sc.nextLine();

                    List<Long> ids = new ArrayList<>();
                    for(String s : line.split(",")){
                        ids.add(Long.parseLong(s.trim()));
                    }

                    orderService.placeOrder(orderCustId,ids);
                    System.out.println("Order Placed.");
                    break;

                // ===============================
                case 8: // Raise Ticket
                    System.out.println("Order ID:");
                    Long orderId = sc.nextLong();
                    sc.nextLine();

                    System.out.println("Issue Description:");
                    String issue = sc.nextLine();

                    ticketService.raiseTicket(orderId,issue);
                    System.out.println("Ticket Raised.");
                    break;

                // ===============================
                case 9: // Employee Performance
                    System.out.println("Employee ID:");
                    Long repId = sc.nextLong();
                    sc.nextLine();

                    reportService.getEmployeePerformance(repId);
                    break;

                // ===============================
                case 10:
                    em.close();
                    emf.close();
                    System.exit(0);
            }
        }
        }
    }