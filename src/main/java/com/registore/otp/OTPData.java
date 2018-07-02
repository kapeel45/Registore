package com.registore.otp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.registore.registration.Registration;

@Entity
@Table(name= "OTP_DATA")
public class OTPData {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(columnDefinition="VARCHAR(10)")
	private String otpCode;
	
	@ManyToOne
	@JoinColumn(name="registration_id")
	private Registration registrationOtpId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOtpCode() {
		return otpCode;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}

	public Registration getRegistrationOtpId() {
		return registrationOtpId;
	}

	public void setRegistrationOtpId(Registration registrationOtpId) {
		this.registrationOtpId = registrationOtpId;
	}
	
}
