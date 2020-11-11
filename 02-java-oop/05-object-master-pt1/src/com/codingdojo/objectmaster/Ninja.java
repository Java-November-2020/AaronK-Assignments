package com.codingdojo.objectmaster;

public class Ninja extends Human {
	public Ninja() {
		this.stealth = 10;
		}

	public void steal(Human stealthat) {
		System.out.println("your health is mine!");
		stealthat.health -= this.stealth;
		System.out.println(stealthat.health);
		this.health += this.stealth;
		System.out.println("Ninja current health:" + this.health);
	}
	
	public void runaway() {
		System.out.println("runaway, runaway, retreat!");
		this.health -= 10;
		System.out.println(this.health);
	}
}
