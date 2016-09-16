package Strings;

import javax.xml.stream.events.Characters;


public class reverseString {
	static int counter = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abc";
		char[] characters = s.toCharArray();
		
		reverse(characters, -1);
		
		
	}
	
	static void reverse(char[] characters, int N){
		
		if(N == characters.length-1)
		{
			return;	
		}
		  N= N+1;
		   reverse(characters, N);
		   System.out.println(characters[N]);

	}

}
