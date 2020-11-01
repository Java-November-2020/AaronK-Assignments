public class StringManipulatorTesting {
    public static void main(String[] args) {

    StringManipulator manipulator = new StringManipulator();
    String str = manipulator.trimAndConcat(" Hello "," World ");
    System.out.println(str); // HelloWorld 




    StringManipulator manny = new StringManipulator();
    // stringmanipulator is the class name from our other file with all our methods. manny is a varibale name we're setting so we can call it on lines 11, 12, 13. must be different from above variable, can't use it twice.
    char letter = 'o';
    Integer a = manny.getIndexOrNull("Coding", letter);
    Integer b = manny.getIndexOrNull("Hello World", letter);
    Integer c = manny.getIndexOrNull("Hi", letter);
    System.out.println(a); // 1
    System.out.println(b); // 4
    System.out.println(c); // null
        



    StringManipulator manipulator3 = new StringManipulator();
    String word = "Hello";
    String subString = "llo";
    String notSubString = "world";
    Integer d = manipulator3.getIndexOrNull2(word, subString);
    Integer e = manipulator3.getIndexOrNull2(word, notSubString);
    System.out.println(d); // 2
    System.out.println(e); // null



    StringManipulator manipulator4 = new StringManipulator();
    String Myword = manipulator4.ConcatSubstring("Hello", 1, 2, "world");
    System.out.println(Myword); // eworld

    }
}