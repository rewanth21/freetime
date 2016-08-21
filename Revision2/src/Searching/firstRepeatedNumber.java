package Searching;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class firstRepeatedNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer[] numbers = {3, 2, 1, 2, 2, 3};
        
        firstDuplicate(numbers);
        
        
	}
	
	static void firstDuplicate(Integer[] numbers){
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		
		for(Integer temp : numbers){
			if(map.containsKey(temp)){
				map.put(temp, (map.get(temp)) + 1);
			}
			else
				map.put(temp, 1);
		}
		
		
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			  Integer key = entry.getKey();
			  Integer value = entry.getValue();

			  

			  if(value > 1){
				  System.out.println("First repeated number is -> " + key + " : " + value);
				  return;
			  }

		}
		
	}

}
