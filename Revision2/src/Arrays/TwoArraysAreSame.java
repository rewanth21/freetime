package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TwoArraysAreSame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array1 = {2,2,3,5,6,7,6,2,1,9,0};
		Integer[] array2 = {2,2,3,5,6,7,6,2,1,9,0};


		sameArrays(array1, array2);

	}

	static void sameArrays(Integer[] array1, Integer[] array2){

		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < array1.length; i++){
			if(map.containsKey(array1[i])){
				map.put(array1[i], map.get(array1[i]) + 1);
			}
			else
				map.put(array1[i], 1);
		}

		for(Integer i : array2){
			if(map.containsKey(i)){
				map.put(i, map.get(i) - 1);
			}
		}
		
		Boolean same = true;
		for(Entry<Integer,Integer> entry : map.entrySet()){
			int value = entry.getValue();
			
			if(value == 0){
				same = true;
			}
			else{
				same = false;
				break;
			}
			
		}
		
		if(same)
			System.out.println("Both arrays are the same");
		else
			System.out.println("Both arrays are not the same");
		
		
	}

}
