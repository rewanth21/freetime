package Strings;

import java.util.HashMap;
import java.util.Map.Entry;

public class PrintAllDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           String s = "geeksforgeeKs123    ";
          
          
           String word1 = s.toLowerCase().replaceAll("[^a-z]+", "");
           char[] array = word1.toCharArray();
           
           
           
           HashMap<Character, Integer> map = new HashMap<>();
           
           for(Character s1 : array){
        	   if(map.containsKey(s1)){
        		   map.put(s1, (map.get(s1) + 1));
        	   }
        	   else
        		   map.put(s1,1);
           }
           
           
           for(Entry<Character, Integer> entry : map.entrySet()){
        	   Character key = entry.getKey();
        	   Integer value = entry.getValue();
        	   
        	   System.out.println(key + " : " + value);
           }
          
	}

}
