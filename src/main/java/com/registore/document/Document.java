package com.registore.document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

import com.registore.registration.Registration;
import com.registore.traceability.Traceability;

@Entity
public class Document extends Traceability{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition="VARCHAR(50)")
	@NotBlank
	private String identityNumber;
	
	
	@Column(columnDefinition="VARCHAR(100)")
	private String identityDetail;

	@ManyToOne
	@JoinColumn(name="registration_id")
	private Registration registrationId;


	public Document(String identityNumber, String identityDetail, Registration registrationId) {
		super();
		this.identityNumber = identityNumber;
		this.identityDetail = identityDetail;
		this.registrationId = registrationId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIdentityNumber() {
		return identityNumber;
	}


	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}


	public String getIdentityDetail() {
		return identityDetail;
	}

	public void setIdentityDetail(String identityDetail) {
		this.identityDetail = identityDetail;
	}

	public Registration getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Registration registrationId) {
		this.registrationId = registrationId;
	}

}
