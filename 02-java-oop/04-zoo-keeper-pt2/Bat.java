// this is an inheritance, an extension of the mammalclass class. 
public class Bat extends MammalClass {


	public void fly() {
		System.out.println("WWHHHHOOOOOSSSSHHHHHHHH");
		energylevel -= 50;
	}
	public void eatHumans() {
		System.out.println("So well, nevermind. mmmm.... humans.");
		energylevel += 25;
	}
	public void attackTown() {
		System.out.println("sound of a town on fire");
		energylevel -= 100;
	}
}