package com.registore.apartment;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.registore.registration.Registration;

@Entity
public class ApartmentRegistration {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition="VARCHAR(45)")
	private String apartmentName;
	
	@Column(columnDefinition="VARCHAR(10)")
	private String wing;
	
	@Column(columnDefinition="VARCHAR(5)")
	private String flatNumber;

	@Column(columnDefinition="VARCHAR(50)")
	private String whomToMeet;
	
	@Column(columnDefinition="VARCHAR(150)")
	private String purpose;
	
	@Column(columnDefinition="VARCHAR(150)")
	private String vehicleNumber;
	
	@Temporal(TemporalType.TIME)
	private Date inTime;
	
	@Temporal(TemporalType.TIME)
	private Date outTime;
	
	@ManyToOne
	@JoinColumn(name="registration_id")
	private Registration registrationId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public Registration getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Registration registrationId) {
		this.registrationId = registrationId;
	}

	public String getWing() {
		return wing;
	}

	public void setWing(String wing) {
		this.wing = wing;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getWhomToMeet() {
		return whomToMeet;
	}

	public void setWhomToMeet(String whomToMeet) {
		this.whomToMeet = whomToMeet;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	
}
