import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class nthMostFrequent {
 static int element = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(4);
		array.add(4);
		array.add(5);
		array.add(0);
		array.add(0);
		array.add(0);
		array.add(0);
		array.add(6);
		array.add(6);
		array.add(6);
		array.add(6);
		array.add(6);
		array.add(6);
		
		
		
        sortbyfrequency(array);
	}
	
	
	static void sortbyfrequency(ArrayList<Integer> array){
		TreeMap<Integer, Integer> frequent = new TreeMap<>();
		HashSet<Integer> numbers = new HashSet<>();
		ArrayList<Integer> keys = new ArrayList<>();
		ArrayList<Integer> values = new ArrayList<>();
		ArrayList<Integer> newvalues = new ArrayList<>();
		
		for(int temp : array){
			if(frequent.containsKey(temp)){
				frequent.put(temp, (frequent.get(temp)) + 1);
			}
			else
				frequent.put(temp, 1);
		}
		
		
		
		for(Map.Entry<Integer,Integer> entry : frequent.entrySet()) {
			  Integer key = entry.getKey();
			  Integer value = entry.getValue();

		System.out.println(key + " " + value);
		
	}
		
		for(Map.Entry<Integer,Integer> entry : frequent.entrySet()) {
			 
			  Integer value = entry.getValue();

			  numbers.add(value);
		
	}
		
		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(frequent.entrySet());
		Collections.sort( list, new Comparator<Map.Entry<Integer, Integer>>()
        {
            public int compare( Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        for(Map.Entry<Integer, Integer> entry:list){
        	  Integer key = entry.getKey();
        	  Integer value = entry.getValue();
        	  keys.add(key);
        	  values.add(value);
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
    
       
        int counter = 1;
        int temp = values.get(0);
        for(int l = 0; l< values.size();l++){
        	
        	if(temp != values.get(l)){
        		counter++;
        		newvalues.add(counter);
        		temp = values.get(l);
        		
        	}
        	else
        		newvalues.add(counter);   
        }
	    
       
	   for(int h : newvalues){
		   System.out.println(h);
	   }
	   
	   
	   
	   
	   
	  for(int z: newvalues){
		  if(z == element){
			  System.out.println(element + " most frequent element is "+ keys.get(element-1));
			  
		  }
			 
		  
	  }
	   
	    
	}

	


	
	static void getnthfrequency(TreeMap<Integer, Integer> frequent, int i){
		
		for(Map.Entry<Integer,Integer> entry : frequent.entrySet()) {
			  

			 if(entry.getValue().equals(i)){
				 System.out.println(entry.getKey());
			 }
	}
	
	}
	
	
}
