package com.aaronkirchhoff.ProductsAndCategories.models;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;


@Entity
@Table(name="houses")
public class House {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
//    this is creating a third entity the easy way with JPA, automatically creates database model, and joins columns is THIS. file, so we call it house_id. and we attach it to foreign object key of Wizard model name, wizard_id. I think name= wizards and houses is setting the name of our third entity? 
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "wizardsAndHouses", 
        joinColumns = @JoinColumn(name = "house_id"), 
        inverseJoinColumns = @JoinColumn(name = "wizard_id")
    )     
    
//    @OneToMany(mappedBy="house", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<WizardsAndHouses> wizardsAndHouses;
	
    
    private List<Wizard> wizards;
    
	public House() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Wizard> getWizards() {
		return wizards;
	}

	public void setWizards(List<Wizard> wizards) {
		this.wizards = wizards;
	}
	
	

}
