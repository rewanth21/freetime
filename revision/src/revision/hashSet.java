package revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class hashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   ArrayList<String> names = new ArrayList<String>();
		   names.add("hello world");
		   names.add("monster");
		   names.add("monster");
		   
           HashMap<String, Integer> nodupnames = new HashMap<String,Integer>();
          int counter = 0;
          
          
          HashSet<String> nodups1 = new HashSet<String>();
          for(String s : names){
        	  nodups1.add(s);
          }
          
           for(String s : names){
        	   if(!nodupnames.containsKey(s)){
        		   nodupnames.put(s, 1);
        	   }
        	   else{
        		   
        	   
        		   
        		   nodupnames.put(s, (nodupnames.get(s)) + 1);
        	   }
           }
           System.out.println(nodups1);
           System.out.println(nodupnames);
           
           
	}

}
