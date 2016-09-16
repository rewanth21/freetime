package LeetCode;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {1,1,1,1,2,3,2,3,2, 4, 4, 4, 4,4,4};
		int n = 4;

		TopKElements(array, n);
	}


	static void TopKElements(Integer[] array, int n){
		TreeMap<Integer,Integer> map = new TreeMap<>();



		for(int temp : array){
			if(map.containsKey(temp)){
				map.put(temp, (map.get(temp)) + 1);
			}
			else
				map.put(temp, 1);
		}

		ArrayList list = new ArrayList(map.entrySet());

		Collections.sort(list,new Comparator(){
			public int compare(Object obj1, Object obj2){
				return ((Comparable)((Map.Entry)(obj2)).getValue

						()).compareTo(((Map.Entry)(obj1)).getValue()); 
			}
		});
		
		for(int i = 0; i < n;i++){
			System.out.println(list.get(i));
		}
	}



}
