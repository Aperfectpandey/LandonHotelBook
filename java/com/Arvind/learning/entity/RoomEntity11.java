package com.Arvind.learning.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

import com.sun.istack.NotNull;
@Lazy
@Entity
@Table
public class RoomEntity11 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private Integer roomNumber;
	@NotNull
	private String price;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<ReservationEntity> reservationEntityList;
	
	public RoomEntity11() {
		super();
	}

	public RoomEntity11(Integer roomNumber,String price) {
		super();
		this.roomNumber=roomNumber;
		this.price=price;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<ReservationEntity> getReservationEntityList() {
		return reservationEntityList;
	}

	public void setReservationEntityList(List<ReservationEntity> reservationEntityList) {
		this.reservationEntityList = reservationEntityList;
	}
	public void addReservationEntity(ReservationEntity reservationEntity) {
		if(null==reservationEntityList) {
			reservationEntityList=new ArrayList<>();
		}
		reservationEntityList.add(reservationEntity);
	}
}
