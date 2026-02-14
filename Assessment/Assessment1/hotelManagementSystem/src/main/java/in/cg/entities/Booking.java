package in.cg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_details")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private String customerName;
	private String roomType;
	private int daysToStay;
	private double totalAmount;
	public Booking() {
		super();
	}
	public Booking(int bookingId, String customerName, String roomType, int daysToStay, double totalAmount) {
		super();
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.roomType = roomType;
		this.daysToStay = daysToStay;
		this.totalAmount = totalAmount;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
	    this.roomType = roomType;
	    this.totalAmount = calculateAmount(this.daysToStay);
	}

	public void setDaysToStay(int daysToStay) {
	    this.daysToStay = daysToStay;
	    this.totalAmount = calculateAmount(daysToStay);
	}

	public int getDaysToStay() {
		return daysToStay;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	 private double calculateAmount(int days) {

	        switch (roomType.toLowerCase()) {
	            case ("standard"): {
	            	return days * 2000;
	            }
	            case ("deluxe"): {
	            	return days * 3500;
	            }
	            case ("suite"): {
	            	return days * 5000;
	            }
	            default: {
	            	return 0;
	            }
	        }
	    }
	
}
