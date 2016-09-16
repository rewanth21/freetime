package LinkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import LinkedList.LinkedList.Node;

public class RemoveDupsFromUnsortedList {

	static Node root;
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
        LinkedList list = new LinkedList();
       LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        
        root = new Node(10);
        root.next = new Node(12);
        root.next.next = new Node(11);
        root.next.next.next = new Node(11);
        root.next.next.next.next = new Node(12);
        root.next.next.next.next.next = new Node(11);
        root.next.next.next.next.next.next = new Node(10);
 
        Node current = root;
        while(current != null){
        	if(map.containsKey(current.data)){
        		current.next = current.next.next;
        	}
        	else 
        		map.put(current.data, 1);
        	
        	current = current.next;
        }
      
       for(Entry<Integer, Integer> entry : map.entrySet()){
    	   int key = entry.getKey();
    	   System.out.println(key);
       }
        
    }

}
