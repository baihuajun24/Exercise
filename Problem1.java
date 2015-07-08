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
        System.out.println(findnumber(numbers));
	}
	
	public static int findnumber(int[] input){
		Hashtable<Integer, Integer> hastbl
	     = new Hashtable<Integer, Integer>();
		Hashtable<Integer, Integer> repeated
	     = new Hashtable<Integer, Integer>();
		// key is the integer from input
		// value is a dummy variable, always set to 1 if a key exists
	    for(int i=0;i<input.length;i++){
	    	if (hastbl.containsKey(input[i])||repeated.containsKey(input[i])){
	    		hastbl.remove(input[i]);
	    	    repeated.put(input[i],1);
	    	}
	    	else
	    		hastbl.put(input[i], 1);
	    }
	    // System.out.println(hastbl.values());
		
	  //finding key corresponding to value in hashtable
	  int result = -1;
	  for (int i:hastbl.keySet())
		  result = i;
	  return result;
	}

}
