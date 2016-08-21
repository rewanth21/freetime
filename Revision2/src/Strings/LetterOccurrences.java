package Strings;

public class LetterOccurrences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		String s = "AABCCCAAAD";
		
		//String[] split = s.split("");
		
		int counter = 1;
		String newstring = "";
		Character last = s.charAt(0);
		
		for(int i = 1; i<s.length();i++){
			if(s.charAt(i) == last){
				counter++;
			}
			else{
				newstring = newstring + last + counter;
				last = s.charAt(i);
				counter = 1;
			}
		}
		newstring = newstring + last + counter;
		System.out.println(newstring);
		
}
}
