package LinkedList;

import LinkedList.RemoveDupsFromUnsortedList.Node;

public class RemoveAlternates {

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
		// TODO Auto-generated method stub
   
		 root = new Node(10);
		 root.next = new Node(11);
		 root.next.next =  new Node(12);
		 root.next.next.next = new Node(11);
	     root.next.next.next.next = new Node(12);
	     root.next.next.next.next.next = new Node(11);
	     root.next.next.next.next.next.next = new Node(10);
	     
	     
	     alternates(root, 1);
	    
	    
	     
	}
	
	
	
	
	
	
	static void alternates(Node root, int k){
		
		if(root == null){
			return;
		}
		
		Node prev = root;
		Node now = root.next;
		
		while(prev != null && now != null){
			prev.next = now.next;
			
			now = null;
			
			
			prev = prev.next;
			if(prev!=null){
				now = prev.next;
			}
			
		}
		
		while(root!= null){
			System.out.println(root.data);
			root = root.next;
		}
		
		
	}

}
