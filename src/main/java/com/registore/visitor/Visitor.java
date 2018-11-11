package com.registore.visitor;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.registore.registration.Registration;
import com.registore.traceability.Traceability;




@Entity
@Table(name="visitor")
public class Visitor extends Traceability {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String apartmentName;
	
	@Column(name = "in_time")
	
	private String inTime;
	
	@Column(name = "out_time")
	
	private String outTime;
	
	
	@Column
	private Date date;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String wing;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String floor;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String flatNo;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String city;
	
	@Column(columnDefinition="VARCHAR(150)")
	private String area;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String pincode;
	
	
	@Column(columnDefinition="VARCHAR(50)")
	private String whomToMeet;
	
	@Column(columnDefinition="VARCHAR(150)")
	private String purpose;
	
	@Column(columnDefinition="VARCHAR(150)")
	private String vehicleNumber;


	

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
	@ManyToOne
	@JoinColumn(name="registration_id")
	private Registration registrationId;
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWing() {
		return wing;
	}

	public void setWing(String wing) {
		this.wing = wing;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	
	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	

	@Override
	public String toString() {
		return "Visitor [userId=" + userId + ", apartmentName=" + apartmentName + ", inTime=" + inTime + ", outTime="
				+ outTime + ", date=" + date + ", wing=" + wing + ", floor=" + floor + ", flatNo=" + flatNo + ", city="
				+ city + ", area=" + area + ", pincode=" + pincode + "]";
	}

	
	
}
