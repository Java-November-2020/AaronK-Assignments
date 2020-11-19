package com.codingdojo.objectmaster;

public class Human {
	public int strength = 3;
	public int stealth = 3;
	public int intelligence =3;
	public int health = 100;

	
	public void attack(Human target) {
		System.out.println("Hiiiyyyaaaahhhhhh!!!");
		target.health -= this.strength;
		System.out.println("Current health:" + target.health);
	}

}
