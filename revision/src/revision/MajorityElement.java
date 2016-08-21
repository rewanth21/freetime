package revision;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] array1 = {6, 1, 3, 5, 5, 6, 5, 5, 5, 5,};
      
      HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
      
      
      
      System.out.println("input");
      for(int temp1 : array1){
    	  if(hm.containsKey(temp1))
    		  hm.put(temp1, (hm.get(temp1)) + 1);
    	  else
    		  hm.put(temp1, 1);
      }
      for(int temp1 : hm.keySet()){
    	  
    	  
    	  
    	  if(hm.get(temp1) >     array1.length/2)
    		  System.out.println(temp1);
      }
      
      System.exit(10);
      
      
    //  findMajority(array1);
	}

	//public static void findMajority(int[] array2)
//	{
	//	Arrays.sort(array2);
	//	int lastindex = array2[0];
		
	//	int count = 0;
	//	int saved = array2[0];
	//	for(int i = 1; i < array2.length; i++)
		{
//			if(array2[i] == lastindex)
//			{
//				
//			 count++;
//			 if (count > array2.length / 2)
//			 {
//				saved = array2[i];
//				
//			 }
//			 else 
//			 {
//				 count = 1; 
//			    lastindex = array2[i];
//			}
//			
//			}
			
			
			
			 
		}
		//System.out.println(saved);
		
	}
