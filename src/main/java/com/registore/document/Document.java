package com.registore.document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition="VARCHAR(50)")
	@NotBlank
	private String identityNumber;
	
	
	@Column(columnDefinition="VARCHAR(100)")
	private String identityDetail;

	@ManyToOne
	@JoinColumn(name="document_id")
	private Document document;


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

}
