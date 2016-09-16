package LinkedList;

import LinkedList.RemoveAlternates.Node;

public class Reversesublist {

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
		 root = new Node(1);
		 root.next = new Node(2);
		 root.next.next =  new Node(3);
		 root.next.next.next = new Node(4);
	     root.next.next.next.next = new Node(5);
	     root.next.next.next.next.next = new Node(6);
	     root.next.next.next.next.next.next = new Node(7);
	     root.next.next.next.next.next.next.next = new Node(8);
	     root.next.next.next.next.next.next.next.next = new Node(9);
	     
	     Node head = reversenode(root, 3);
	     
	     while(head !=null){
	    	 System.out.println(head.data);
	    	 head = head.next;
	     }
	}

	 static Node reversenode(Node head, int k)
	    {
	       Node current = head;
	       Node next = null;
	       Node prev = null;
	        
	       int count = 0;
	 
	       /* Reverse first k nodes of linked list */
	       while (count < k && current != null) 
	       {
	           next = current.next;
	           current.next = prev;
	           prev = current;
	           current = next;
	           count++;
	       }
	 
	       /* next is now a pointer to (k+1)th node 
	          Recursively call for the list starting from current.
	          And make rest of the list as next of first node */
	       if (next != null) 
	          head.next = reversenode(next, k);
	 
	       // prev is now head of input list
	       return prev;
	    }   
}
