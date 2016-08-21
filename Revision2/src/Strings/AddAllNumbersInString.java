package Strings;

public class AddAllNumbersInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1ab236c6s222";
		int sum = 0;
		String newstring = "";
		int number = 0;
		for(int i = 0; i < s.length(); i++){
			if(Character.isDigit(s.charAt(i))){
				newstring =  newstring + s.charAt(i);
				
			}
			
			else{
				if(newstring.length() > 0){
					number = Integer.parseInt(newstring);
					
					sum = sum + number;
					newstring = "";
					System.out.println(number);
					number = 0;
				}
				
			}
		}
		number = Integer.parseInt(newstring);
		sum = sum + number;
		System.out.println(sum);
		
		
		
		
		
	}
	




}
