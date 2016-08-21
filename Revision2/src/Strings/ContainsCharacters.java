package Strings;

import java.util.ArrayList;

public class ContainsCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ArrayList<String> list = new ArrayList<>();
       list.add("sunday");
       list.add("utensils");
       list.add("geeksforgeeks");
       
       
       for(String word : list){
    	   if (word.contains(".+[sun].+")){
    		   System.out.println(word);
    	   }

       }
       
	}

}
