package revision;

import java.util.Arrays;

public class oneCharDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String s1 = "banana";
         String[] a1 = {"nana", "baban", "banaba", "abfsdc", "bayana", "banxna"};
         
         findmatch(s1, a1);
	}
	
	public static void findmatch(String s, String[] sa){
		
		
		char[] chars = s.toCharArray();
		
		
		for(int i = 0; i< sa.length;i++){
			char[] s1 = sa[i].toCharArray();
		
			
			int counter = 0;
			if(chars.length == s1.length){
			
			for(int k=0; k<chars.length || k<s1.length;){
				
					if(chars[k] == (s1[k]))
						k++;
					
					else{
					  counter++;
					  k++;
					}
				}
				
			}
		
			if (counter == 1)
			  System.out.println(sa[i]);
		}
	}

}
