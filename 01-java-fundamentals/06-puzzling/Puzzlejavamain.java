import java.util.ArrayList;
import java.util.Arrays;

public class puzzlejavamain {
    public static void main(String[] args) {

        puzzlejava Puzzle = new puzzlejava();

        int Arr[] = new int[] {3, 5, 1, 2, 7, 9, 8, 13, 25, 32};
        int x = 10;
        Puzzle.myArray(Arr);
        System.out.println(Arrays.toString(Puzzle.myArray(Arr, x)));





    }
}