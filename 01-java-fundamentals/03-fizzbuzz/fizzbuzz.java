public class fizzbuzz {

    public void fizzbuzztester(){
        for(int i = 1; i <= 100; i++){
            String result = fizzbuzz(i);
            System.out.println("number: " + i + "-" + "Result: " + result);
        }
    }

    public String fizzbuzz(int val){
        if(val % 3 == 0 && val % 5 == 0){
            return "FizzBuzz";
        }   
            else if(val % 3 == 0){
            return "Fizz";
        }
            else if(val % 5 == 0){
                return "Buzz";
        }
            else {
                return Integer.toString(val);
        }
    }
}