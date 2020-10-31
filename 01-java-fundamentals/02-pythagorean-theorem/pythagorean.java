import java.lang.Math;
public class pythagorean {
    // calculatehypotenuse is the name of this method. double is a type cast, holding many decimal places. then we have two intigers (numbers) called legA and legB.
    public double calculateHypotenuse(int legA, int legB) {
        double sideA = legA;
        double sideB = legB;
        double sideC = Math.sqrt((sideA * sideA) + (sideB * sideB));
        return sideC;
    }

}