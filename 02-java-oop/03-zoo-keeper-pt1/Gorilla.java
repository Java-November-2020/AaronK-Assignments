// this is an inheritance, an extension of the mammalclass class. 
public class Gorilla extends MammalClass {
    
    
    // so definitely no constructor methods, why?

	public void throwSomething() {
		System.out.println("throwing stuff here");
		energylevel -= 5;
	}
	public void eatBanana() {
		System.out.println("eating bananas");
		energylevel += 10;
	}
	public void climb() {
		System.out.println("climbing stuff here");
		energylevel -= 10;
	}
}