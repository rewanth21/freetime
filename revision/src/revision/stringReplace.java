package revision;

import java.util.Scanner;

public class stringReplace{
	
		public static void main(String[] args)
		{
			String inp = "abcd e df w ";
			StringBuffer content = new StringBuffer(inp);
			String n = "";
			for(int i = 0; i <inp.length(); i++)
			{
				if (inp.charAt(i) == ' ')
				{
					n = n + "%20";
				}
				else 
					n = n + inp.charAt(i);
			}
			System.out.println(n);
		}
		
}




	
