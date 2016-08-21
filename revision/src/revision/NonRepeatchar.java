package revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;



public class NonRepeatchar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "amphibian";
		getNonRepeat(s1);
	}

	public static void getNonRepeat(String s){
		String [] newstr= s.split("");

		Map<String, Integer> mapper = new LinkedHashMap<String, Integer>();

		for(String s2 : newstr){
			if(mapper.containsKey(s2)){
				
				mapper.put(s2, (mapper.get(s2)) + 1);
			}
			else
				
			    mapper.put(s2, 1);
		}
		
		ArrayList<String> ones = new ArrayList<String>();
		for (String key: mapper.keySet()){
			if(mapper.get(key) == 1){
				
				ones.add(key);
			}
			
			
		}
		System.out.println(mapper);
	    System.out.println(ones.get(0));
	    System.out.println(ones);
		
	}
		 
		



}


