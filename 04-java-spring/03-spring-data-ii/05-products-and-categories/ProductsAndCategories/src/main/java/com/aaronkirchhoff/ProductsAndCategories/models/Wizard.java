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
@Table(name="wizards")
public class Wizard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String background;
	private double money;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	
//	if this is the name of my third auto many to may model JPA made for me, wizardsAndHouses, why does my controller not recognize it? do i have to delete that manually created third entity model WizardsAndHouses? 
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="wizardsAndHouses",
		joinColumns=@JoinColumn(name="wizard_id"),
		inverseJoinColumns=@JoinColumn(name="house_id")
	)
	
//	@OneToMany(mappedBy="wizard", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<WizardsAndHouses> wizardsAndHouses;
	
//	list of houses is the variable name referenceing my wizard class
	private List<House> houses;

	public Wizard() {
		
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

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
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

	public List<House> getHouses() {
		return houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}
	
	
	

}
