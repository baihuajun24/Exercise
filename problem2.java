import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class problem2 {
	static ArrayList<Integer> primelist = new ArrayList<Integer>();
	static int maxNumDivisor = 2;
	static HashMap<Integer,HashMap<Integer,Integer>> factorMap 
	= new HashMap<Integer,HashMap<Integer,Integer>>();
	
	/** Find the total number of divisors of m, return true if it's greater than the 
	  * total number of divisors of all composites smaller than m, false otherwise */
	public static boolean isSuperCompo(int m){
		int NoD = findNumOfDivisor(m);
		//System.out.println(m);
		if ( NoD > maxNumDivisor){
			maxNumDivisor = NoD;
			System.out.println(factorMap.get(m));
			//System.out.println(NoD);
			return true;
		}
		else
			return false;
	}
	
	/** Given integer m, return the number of divisors for m. */
	public static int findNumOfDivisor(int m){
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		h = primefactor(m,h);
		factorMap.put(m, h);
		int numOfDivisor = 1;
		for(Integer d: h.values()){
			numOfDivisor = numOfDivisor*(d+1);
		}
		return numOfDivisor;
	}
	
	/** An iterative method to prime factorize an integer m.
	 *  Store prime factors as key, and their degrees as value in to a HashMap
	 *  return such HashMap as result */
	public static HashMap<Integer,Integer> primefactor(int m, HashMap<Integer,Integer> h){
				for (int i=2; i<=m;i++){
					if (m%i==0){
						int next = m/i;
						if (factorMap.containsKey(next)) {
							h = factorMap.get(next);
							h.put(i, h.getOrDefault(i, 0)+1);
						}
						else
							h.put(m, h.getOrDefault(m, 0)+1);
					}
			    }
				return h;
	}
	
	/** Return an int array containing the first n super composite numbers starting from 2*/
    public static int[] findSuperCombo(int n){
    	int i = 2; // Starting from the smallest composite number
    	int counter = 0; // Counting the number of super composite number found
    	int[] result = new int[n];
    	while(counter<n){
    			if(isSuperCompo(i)){
    				result[counter] = i;
    				counter++;
    			}
    		i++;
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	int n;
    	while (true){
    	System.out.println("Please enter how many super composite numbers you want:");
    	Scanner s = new Scanner(System.in);
    	n = s.nextInt();
    	if (n>0) break;
    	else
    		System.out.println("Invalid argument: please enter a positive integer");
        }
        System.out.println(Arrays.toString(findSuperCombo(n)));
    	/*for (int i = 2;i<=9;i++)
        System.out.println(findNumOfDivisor(i));*/
    }
}
