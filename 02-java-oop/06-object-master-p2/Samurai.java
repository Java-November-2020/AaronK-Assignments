package com.codingdojo.objectmaster;

public class Samurai extends Human {
	public static int count = 0;
	
	public Samurai() {
		this.health = 200;
	}
	
	public void deathBlow(Human superpunch) {
		System.out.println("**finishing move**");
		superpunch.health = 0;
		this.health = this.health / 2;
		System.out.println("Your opponent was KO'd! health:" + superpunch.health);
		System.out.println("Samurai current health:" + this.health);
				
	}

	public void meditate() {
		System.out.println("Spirit heal me.");
		this.health = 200;
		System.out.println("Samurai current health:" + this.health);
		
	}
	
	public int howMany() {
		Samurai.count = count + 1;
        System.out.println("Total Number of Samurai are now: " + count);
		return count;
		
	}
}
