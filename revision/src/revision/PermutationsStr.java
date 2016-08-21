package revision;

import java.util.ArrayList;

public class PermutationsStr {
	public static void permutation(String str) { 
	    permutation("", str); 
	}
    static ArrayList<String> array = new ArrayList<String>();
	private static void permutation(String prefix, String str) {
		
	    int n = str.length();
	    if (n == 0) array.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
      
        public static void main(String[] args){
                permutation("abc");
                System.out.println(array);
        }
}