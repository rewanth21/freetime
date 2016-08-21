package revision;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firststr = "acad";
		String secondstr = "daca";
				
		String newstr = getReverse(firststr);
		System.out.println(firststr);
		System.out.println(newstr);
		checkPalindrome(newstr, secondstr);
       
       
      
		
	}
	
	public static String getReverse(String str)
	{
		 char[] allchars = str.toCharArray();
	       
	       int strl = str.length();
	       String newstr = "";
	       for (int i = strl - 1; i >= 0; i--)
	       {
	    	   newstr = newstr + allchars[i];
	    	 }
	       
	       return newstr;
	}
	
	public static Boolean checkPalindrome(String str1, String str2)
	{
		boolean correct = false;
		if (str1.equals(str2))
		{
			correct = true;
			
		}
		else 
			correct = false;
			
		System.out.println(correct);
		return correct;
		
	}
	
}
