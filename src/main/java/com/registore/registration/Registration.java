package com.registore.registration;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;


import com.registore.document.Document;
import com.registore.otp.OTPData;
import com.registore.traceability.Traceability;
import com.registore.visitor.Visitor;

@Entity
public class Registration extends Traceability {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(columnDefinition="VARCHAR(50)")
	private String firstname;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String middlename;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String lastname;
	
	@Column(columnDefinition="VARCHAR(150)")
	private String area;
	
	//@Max(10)
	@Column(unique = true)
	private String mobile;
	
	@Email
	@Column(unique = true)
	private String email;
	
	@Column(columnDefinition="VARCHAR(1)")
	private String gender;
	
	@OneToMany(mappedBy = "registrationId", cascade = CascadeType.ALL)
	private List<Document> listDocument = new ArrayList<Document>();
	
	@OneToMany(mappedBy = "registrationId", cascade = CascadeType.ALL)
	private List<Visitor> listApartment = new ArrayList<Visitor>();
	
	@OneToMany(mappedBy = "registrationOtpId", cascade = CascadeType.ALL)
	private List<OTPData>  otpData = new ArrayList<OTPData>();

	protected Registration(){}
	
	public Registration( String firstname, String middlename, String lastname, String area, String mobile,
			String email, String gender) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.area = area;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
