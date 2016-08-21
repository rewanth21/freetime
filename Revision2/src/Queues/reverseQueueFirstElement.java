package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseQueueFirstElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Queue<Integer> queue = new LinkedList<>();
     queue.add(1);
     queue.add(2);
     queue.add(3);
     queue.add(4);
     queue.add(5);
     queue.add(6);
     queue.add(7);
     
     int n = 4;
     
     limitedReverse(queue, n);
     
	}
	
	static void limitedReverse(Queue<Integer> queue, int n){
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue2 = new LinkedList<>();
		 int counter = 0;
		
		while(counter<n){
			stack.push(queue.poll());
			counter++;
		}
		
		while(!stack.isEmpty()){
			queue2.add(stack.pop());
		}
		
		while(!queue.isEmpty()){
			queue2.add(queue.remove());
		}
		
		
		while(!queue2.isEmpty()){
			System.out.print(queue2.remove());
		}
	}
	

	

}
