package revision;

import java.io.IOException;

public class repeatedLetter {
  public static void main(String[] args) throws IOException
  {
	  String inp = "abbccddeeaaa";
	  if(inp.isEmpty())
	  {
		  System.out.println("please give an input");
	  }
	compressBad(inp);
  }
  
  public static void compressBad(String str)
  {
	String newstr = "";
	char last = str.charAt(0);
	int count = 1;
	
	for(int i = 1; i < str.length(); i++)
	{
		for(int j = 1; j <str.length(); j++)
		if (str.charAt(i) == last)
		{
			count++;
		}
		else
		{
			newstr += last + ":" + count;
			last = str.charAt(i);
			count = 1;
		}

	}
	System.out.println(newstr + last + ":" +count);
	  
  }
}
