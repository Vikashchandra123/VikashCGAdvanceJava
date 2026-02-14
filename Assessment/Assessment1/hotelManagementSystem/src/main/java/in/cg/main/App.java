package in.cg.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.cg.entities.Booking;

public class App {

    static Scanner sc = new Scanner(System.in);
    private static SessionFactory factory;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("/in/cg/config/hibernate.cfg.xml");
            factory = cfg.buildSessionFactory();
        } catch (Exception e) {
            System.out.println("SessionFactory creation failed");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n---------------- HOTEL MANAGEMENT --------------");
            System.out.println("1. Add Booking");
            System.out.println("2. View All Bookings");
            System.out.println("3. Update Booking");
            System.out.println("4. Delete Booking");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addBooking(); break;
                case 2: viewBookings(); break;
                case 3: updateBooking(); break;
                case 4: deleteBooking(); break;
                case 5: System.exit(0);
            }
        }
    }

    // ADD BOOKING
    private static void addBooking() {

        Transaction tx = null;

        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();

            Booking b = new Booking();

            System.out.print("Customer Name: ");
            b.setCustomerName(sc.next());

            System.out.print("Room Type (standard/deluxe/suite): ");
            b.setRoomType(sc.next());

            System.out.print("Days to stay: ");
            int days = sc.nextInt();
            b.setDaysToStay(days);

            session.persist(b);   

            tx.commit();
            System.out.println("Booking added successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Error adding booking");
            e.printStackTrace();
        }
    }

    // VIEW ALL BOOKINGS
    private static void viewBookings() {

        try (Session session = factory.openSession()) {

            System.out.println("\n---- ALL BOOKINGS ----");

            session.createQuery("from Booking", Booking.class)
                   .stream()
                   .forEach(b -> System.out.println(
                           b.getBookingId() + " | " +
                           b.getCustomerName() + " | " +
                           b.getRoomType() + " | " +
                           b.getDaysToStay() + " days | " +
                           b.getTotalAmount()
                   ));

        } catch (Exception e) {
            System.out.println("Error fetching bookings");
            e.printStackTrace();
        }
    }


    // UPDATE BOOKING
    private static void updateBooking() {

        Transaction tx = null;

        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();

            System.out.print("Enter booking id: ");
            int id = sc.nextInt();

            Booking b = session.get(Booking.class, id);

            if (b != null) {

                System.out.print("New name: ");
                sc.nextLine(); 
                b.setCustomerName(sc.next());

                System.out.print("New room type: ");
                b.setRoomType(sc.next());

                System.out.print("New days: ");
                int days = sc.nextInt();
                b.setDaysToStay(days);

                session.merge(b);   

                tx.commit();
                System.out.println("Updated successfully!");
            } else {
                System.out.println("Booking not found");
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Error updating booking");
            e.printStackTrace();
        }
    }

    // DELETE BOOKING
    private static void deleteBooking() {

        Transaction tx = null;

        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();

            System.out.print("Enter booking id: ");
            int id = sc.nextInt();

            Booking b = session.get(Booking.class, id);

            if (b != null) {
                session.remove(b);   
                tx.commit();
                System.out.println("Deleted successfully!");
            } else {
                System.out.println("Booking not found");
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Error deleting booking");
            e.printStackTrace();
        }
    }
}
