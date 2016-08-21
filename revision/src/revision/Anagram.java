package revision;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         isAnagram("cinema21&", "anemic");
	}
	
	public static void isAnagram(String s1, String s2)
	{
		
	String word1 = s1.replaceAll("^a-z", "");
	String word2 = s2.replaceAll("^a-z", "");
	
	//System.out.println(word1);
		
	 char[] array1 = s1.toLowerCase().toCharArray();
	 char[] array2 = s2.toLowerCase().toCharArray();
	 
	 Arrays.sort(array1);
	 Arrays.sort(array2);
	 
	 //System.out.println(array1);
	 //System.out.println(array2);
	 
	 if (Arrays.equals(array1, array2))
	 {
		 System.out.println("The given strings are anagrams");
	 }
	 else
		 System.out.println("The given strings are not anagrams");

		 
	 
	}

}
