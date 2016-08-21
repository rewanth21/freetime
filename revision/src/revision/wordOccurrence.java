package revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class wordOccurrence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String[] words = new String[6];
       words[0] = "cats";
       words[1] = "dogs";
       words[2] = "dogs";
       words[3] = "dogs";
       words[4] = "cats";
       words[5] = "dogs";
       Arrays.sort(words);
      //for(int i =0; i < words.length; i++)
     // {
    //	  System.out.println(words[i]);
     // }
       findOccurence(words);
       
	}
	
	public static void findOccurence(String[] array)
	{
		
		String lastWord = array[0];
		int counter  = 1;
		for (int i = 1; i < array.length; i++)
		{
			if(array[i] == lastWord)
			{
				counter++;
				
			}
			else
			{
				System.out.println(lastWord + ":" + counter);
				lastWord = array[i];
				counter = 1;
			}
		}
	}

	 /* public static void findOccurence(String[] array)
	  {   
		  
		  int count = 0;
		 String lastindex = array[count];
		 HashMap<String, Integer> stringCounter=new HashMap<String,Integer>();
		 for(int i = 1; i < array.length; i++)
		 {
			 if(stringCounter.containsKey(array[i]))
			 {
				stringCounter.put(lastindex, stringCounter.get(lastindex) + 1);
				count++;
			 }
			 else
			 {
				stringCounter.put(lastindex, 1);
				
			 }
		 
		 }
		 System.out.println(stringCounter);
		 for(String key:stringCounter.keySet())
	       {
	           System.out.println(key+":"+stringCounter.get(key));
	       }
		}*/
	  }

