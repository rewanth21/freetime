package Strings;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        String s = "AABC";
        String[] stringarray = s.split("");
        
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        
        for(String string : stringarray){
        	if(map.containsKey(string)){
        		map.put(string, map.get(string) + 1);
        	}
        	else
        		map.put(string, 1);
        }
        
        String[] newstringarray = new String[map.size()];
        
        int[] count = new int[map.size()];
        int i = 0;
        for(Entry<String, Integer> entry : map.entrySet()){
        	String key = entry.getKey();
        	int value = entry.getValue();
        	newstringarray[i] = key;
        	count[i] = value;
        	i++;
        }
        
        String[] result = new String[s.length()];
        
        permuteUtil(newstringarray, count, result, 0);
        
        
       
        
    }
	
	static void permuteUtil(String str[], int count[], String result[], int level){
		if(level == result.length){
			for(String s : result){
				System.out.print(s);
			}
			System.out.println();
		}
		
		for(int i = 0; i < str.length;i++){
			if(count[i] == 0){
				continue;
			}
			
			result[level] = str[i];
			count[i]--;
			permuteUtil(str, count, result, level+1);
			count[i]++;
		}
		
	}
	
	
}
