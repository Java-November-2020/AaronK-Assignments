package com.codingdojo.objectmaster;

public class Wizard extends Human {
	public Wizard() {
	this.intelligence = 8;
	this.health = 50;
	}
	
	public void heal(Human healme) {
		System.out.println("I heal you now.");
		healme.health += this.intelligence;
		System.out.println("Current health:" + healme.health);
	}
	
	public void fireball(Human fireattack) {
		System.out.println("take that you scoundrel!");
		fireattack.health -= 3 * this.intelligence;
		System.out.println("Current health:" + fireattack.health);
	}
}
