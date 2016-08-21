package revision;

import java.awt.List;
import java.util.LinkedList;

public class printLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       LinkedList alist = new LinkedList();
       
       
       alist.add("hello");
   
       alist.add("world");
       alist.add("hello");
       alist.addLast("last");
       alist.addFirst("first");
       alist.add(1, "new");
       printMe(alist);
       addMe(alist, "olla", 3);
    System.out.println(alist);
    
	}

	public static void printMe(LinkedList<String> l){
		for(int i = 0; i < l.size(); i++){
			if (l.get(i) == "hello"){
				l.add(i+1, "meow");
			}
		}
	}
	
	public static void addMe(LinkedList<String> l, String a, int pos){
		
		for(int i = 0; i < l.size(); i++){
			if(i == pos){
				l.add(i, a);
			}
			
		}
	}
	
}
