package LinkedList;

import java.awt.List;
import java.util.ArrayList;

//Java program to delete nodes which have a greater value on 
//right side
class LinkedList
{
 Node head;  // head of list

 /* Linked list Node*/
 class Node
 {
     int data;
     Node next;
     Node(int d)  { data = d; next = null; }
 }



 /* Utility functions */

 /* Inserts a new Node at front of the list. */
 void push(int new_data)
 {
     /* 1 & 2: Allocate the Node &
               Put in the data*/
     Node new_node = new Node(new_data);

     /* 3. Make next of new Node as head */
     new_node.next = head;

     /* 4. Move the head to point to new Node */
     head = new_node;
 }




 /* Drier program to test above functions */
 public static void main(String args[])
 {
     LinkedList llist = new LinkedList();

     /* Constructed Linked List is 12->15->10->11->
        5->6->2->3 */
     llist.push(3);
     llist.push(2);
     llist.push(6);
     llist.push(5);
     llist.push(11);
     llist.push(10);
     llist.push(15);
     llist.push(12);

     
     Arrange(llist.head);
    
 }
 
 static void Arrange(Node head){
	 
	 Node current = head;
	 Node newcurrent;
	 LinkedList llist2 = new LinkedList();
	 
	 ArrayList<Integer> even = new ArrayList<>();
	 
	 
	 while(current != null){
		 if((current.data % 2) == 0){
			 even.add(current.data);
			 current = current.next;
		 }
		 else{
			 llist2.push(current.data);
			 current = current.next;
		 }
			
		 
	 }
	 
	 
	 for(Integer i : even){
		 llist2.push(i);
	 }
	 
	 newcurrent = llist2.head;
	 
	 while(newcurrent != null){
		 System.out.println(newcurrent.data);
		 newcurrent = newcurrent.next;
	 }
	 
 }
 
} /* This code is contributed by Rajat Mishra */
