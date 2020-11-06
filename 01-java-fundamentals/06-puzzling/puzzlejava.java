import java.util.ArrayList;
import java.util.Arrays;


public class puzzlejava {

    public void myArray(int[] arr, int x){
        int count= 0;
        int[] greater=0;
        for(int i=0; i< arr.length; i++){
            count = arr[i] + count;
            if(arr[i] > x){
                greater = greater + arr[i];
            }           
        }
        System.out.println(count);
        System.out.println(greater);
        return count;
    }



}