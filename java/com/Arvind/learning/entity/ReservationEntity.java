package com.Arvind.learning.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="Reservation")
public class ReservationEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private LocalDate checkin;
	@NotNull
	private LocalDate checkout;
	@ManyToOne
	private RoomEntity11 roomEntity;
	
	
	 public ReservationEntity() {
		super();
	}
	public ReservationEntity(long id, LocalDate checkin, LocalDate checkout) {
		super();
		this.id = id;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public RoomEntity11 getRoomEntity() {
		return roomEntity;
	}
	public void setRoomEntity(RoomEntity11 roomEntity) {
		this.roomEntity = roomEntity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getCheckin() {
		return checkin;
	}
	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}
	public LocalDate getCheckout() {
		return checkout;
	}
	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

	
}
