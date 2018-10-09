package com.registore.apartment.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apartment_register")
public class ApartmentRegister {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long apartRegId;
	
	@Column(columnDefinition = "VARCHAR(150)")
	private String apartmentName;
	
	private Long noOfWings;
	
	@Column(columnDefinition ="VARCHAR(50)")
	private String wingsName;
	
	private int noOfFloors;
	
	private int noOfFlats;
	
	private int noOfFlatsOnEachFloor;
	
	private String location;
	
	@Column(columnDefinition="DECIMAL(11,8)")
	private Double longitude;
	
	@Column(columnDefinition = "DECIMAL(10,8)")
	private Double latitude;

	public Long getApartRegId() {
		return apartRegId;
	}

	public void setApartRegId(Long apartRegId) {
		this.apartRegId = apartRegId;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public Long getNoOfWings() {
		return noOfWings;
	}

	public void setNoOfWings(Long noOfWings) {
		this.noOfWings = noOfWings;
	}

	public String getWingsName() {
		return wingsName;
	}

	public void setWingsName(String wingsName) {
		this.wingsName = wingsName;
	}

	public int getNoOfFloors() {
		return noOfFloors;
	}

	public void setNoOfFloors(int noOfFloors) {
		this.noOfFloors = noOfFloors;
	}

	public int getNoOfFlats() {
		return noOfFlats;
	}

	public void setNoOfFlats(int noOfFlats) {
		this.noOfFlats = noOfFlats;
	}

	public int getNoOfFlatsOnEachFloor() {
		return noOfFlatsOnEachFloor;
	}

	public void setNoOfFlatsOnEachFloor(int noOfFlatsOnEachFloor) {
		this.noOfFlatsOnEachFloor = noOfFlatsOnEachFloor;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
}