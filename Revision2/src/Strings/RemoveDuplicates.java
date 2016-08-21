package Strings;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str = "    this is    a   string  containing numerous  whitespaces   ";
		//str = str.replaceAll(" +", " ").replaceAll("^ ", "").replaceAll(" $", "");
		//System.out.println(str);
		
        String string = "eeeefggkkossfs";
        
        char last = string.charAt(0);
        String newstring = "";
        
        for(int i = 1; i < string.length();i++){
        	if(string.charAt(i) != last){
        		newstring = newstring + last;
        		last = string.charAt(i);
        	}
        	
        }
        System.out.println(newstring + last);
        
		
	}

}
