public class StringManipulator {
    public String trimAndConcat(String val1, String val2){
    // String is a type cast because in Java we have to declare what the variable is. trimAndConcat is the method name. and inside we have to parameters which we declare as strings. 
    return val1.trim().concat(val2.trim());
    }

    public static Integer getIndexOrNull(String input, char val2){
        return input.indexOf(val2) != -1 ? input.indexOf(val2) : null;
    }

    public static Integer getIndexOrNull2(String input, String val2){
        return input.indexOf(val2) != -1 ? input.indexOf(val2) : null;
    }



    public static String ConcatSubstring(String input, int idxA, int idxB, String replacement) {
        String substr;
        try{
            substr = input.substring(idxA, idxB);
        } catch(IndexOutOfBoundsException e) {
            System.out.println(String.format("Exception caught: %s", e));
            substr = "LOL";
        }

        return substr.concat(replacement);
    }
}