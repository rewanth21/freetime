package revision;

public class upperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String inp = "abA";
       Boolean b = false;
       char[] allchars = inp.toCharArray();
       
       for (char c : allchars)
       {
    	   if(Character.isUpperCase(c))
    	   {
    		   b = true;
    	   }
    	   else 
    		   b = false;
       }
       System.out.println(b);
    	   
	}

}
