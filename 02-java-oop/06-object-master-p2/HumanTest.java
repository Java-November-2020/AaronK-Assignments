package com.codingdojo.objectmaster;
public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Human myhuman = new Human();
		Wizard wizkid = new Wizard();
		Ninja kickchop = new Ninja();
		Samurai sword = new Samurai();
		Samurai legend = new Samurai();
		Samurai stone = new Samurai();
		
		myhuman.attack(myhuman);
		
		
//		wizard can heal himself, fireball a human, a ninja can steal health from a wizard and a ninja can runaway and lose some health.
		wizkid.heal(wizkid);
		wizkid.fireball(myhuman);
		kickchop.steal(wizkid);
		kickchop.runaway();
		
//		samurai can give a death blow.
		sword.deathBlow(kickchop);
		System.out.println("Ninja current health:" + kickchop.health);
		
//		samurai can heal himself.
		sword.meditate();
		
//		how many samurai are there?
		sword.howMany();
		legend.howMany();
		stone.howMany();
//		the count of how many samurai's doesn't appear until we call the method to count it.
		
		

	}

}
