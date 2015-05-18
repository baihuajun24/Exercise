import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;

public class Problem1 {

	public static void main(String[] args) {
		
		// input int array to [numbers]
		/* input format: 
		   length of array
		   array elements*/  
		Scanner s = new Scanner(System.in);

        int count = s.nextInt();
        s.nextLine(); // throw away the newline.

        int [] numbers = new int[count];
        Scanner numScanner = new Scanner(s.nextLine());
        for (int i = 0; i < count; i++) {
            if (numScanner.hasNextInt()) {
                numbers[i] = numScanner.nextInt();
            } else {
                System.out.println("You didn't provide enough numbers");
                break;
            }
        }
        
        // System.out.println(Arrays.toString(numbers));
        System.out.println(findnumber(numbers));
	}
	
	public static int findnumber(int[] input){
		Hashtable<Integer, Integer> hastbl
	     = new Hashtable<Integer, Integer>();
		// key is the integer from input
		// value is the number of times it already appears
	    for(int i=0;i<input.length;i++){
	    	if (hastbl.containsKey(input[i]))
	    		hastbl.put(input[i], hastbl.get(input[i])+1);
	    	else
	    		hastbl.put(input[i], 1);
	    	if (3*hastbl.size()>input.length)
	    		break;
	    }
	    // System.out.println(hastbl.values());
		
	  //finding key corresponding to value in hashtable
	  int findvalue = 0;
	    for(int i=0;i<input.length;i++){
	    	if (hastbl.get(input[i])==1){
	    		findvalue = input[i];
	    		break;
	    	}
	    }
	  return findvalue;
	}

}
