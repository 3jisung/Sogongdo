package model;

import java.time.LocalDateTime;

public class ReservationPayment {
	private String User_id;	
	private LocalDateTime saleDate;
	private String Reservation_id;
	private int fee;
	private LocalDateTime cancelDate;
	
	public ReservationPayment() {}

	public ReservationPayment(String user_id, LocalDateTime saleDate, String reservation_id, int fee) {
		User_id = user_id;
		this.saleDate = saleDate;
		Reservation_id = reservation_id;
		this.fee = fee;
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getReservation_id() {
		return Reservation_id;
	}

	public void setReservation_id(String reservation_id) {
		Reservation_id = reservation_id;
	}

	public LocalDateTime getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDateTime saleDate) {
		this.saleDate = saleDate;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public LocalDateTime getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(LocalDateTime cancelDate) {
		this.cancelDate = cancelDate;
	};
}
