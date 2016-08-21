import java.util.Arrays;

public class Anagram2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        isAnagram("  cinemI2&a", "an%3 imec");
	}
     static void isAnagram(String s1, String s2){
    	 String word1 = s1.replaceAll("[^a-z]+", "");
    	 String word2 = s2.replaceAll("[^a-z]+", "");
    	 
    	 System.out.println(word1);
    	 
    	 
    	 char[] a1 = word1.toLowerCase().toCharArray();
    	 char[] a2 = word2.toLowerCase().toCharArray();
    	 
    	 Arrays.sort(a1);
    	 Arrays.sort(a2);
    	 
    	 if(Arrays.equals(a1, a2)){
    		 System.out.println("The given words are anagrams");
    	 }
    	 else
    		 System.out.println("The given words aren't anagrams");
    	 
    	 
     }
}
