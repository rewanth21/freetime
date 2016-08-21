package LinkedList;

import LinkedList.LinkedList.Node;

public class DeleteCertainNodes {
	Node head;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	     llist.push(1);

	     
	     int M = 2;
	     int N = 2;
	     
	     Node current = llist.head;
	     while(current != null){
				System.out.println(current.data);
				current = current.next;
			}
	     //N is the number of nodes to delete
	     //M is the number of nodes after
	     
	     delete(llist.head, M, N);
	     Node newcurrent = llist.head;
	     
	     System.out.println();
	     while(newcurrent != null){
				System.out.println(newcurrent.data);
				newcurrent = newcurrent.next;
			}
			
	}
	
	static void delete(Node head, int M, int N){
	   Node current = head;
		

		
		while(current != null){
			for(int count = 1; count < M; count++){
				current = current.next;
			}
			if (current == null){
				return;
			}
			
			
			Node temp = current.next;
			
			for(int count = 1; count <=N && temp !=null;count++){
				temp = temp.next; 
			}
			
			current.next = temp;
			current = temp;
			
		}
		 
		
	}

}
