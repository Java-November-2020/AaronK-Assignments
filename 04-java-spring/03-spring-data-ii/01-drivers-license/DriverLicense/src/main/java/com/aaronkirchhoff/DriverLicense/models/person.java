package com.aaronkirchhoff.DriverLicense.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="persons")
public class person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotBlank
    @Size(max = 30, message="must be less than 30 characters.")
    private String firstName;
	@NotBlank
    @Size(max = 30, message="must be less than 30 characters.")
	private String lastName;
	
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private license license;
    
    public person() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public license getLicense() {
		return license;
	}

	public void setLicense(license license) {
		this.license = license;
	}
    

}
