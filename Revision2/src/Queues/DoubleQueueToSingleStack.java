package Queues;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DoubleQueueToSingleStack {

	public static void main(String[] args){
		
		
		int[] array = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		
		
		int mid = array.length/2;
		
		Queue<Integer> queue1 = new LinkedList<Integer>();
		
		Queue<Integer> queue2 = new LinkedList<Integer>();
		
		
		for(int i = 0; i < mid; i++){
			queue1.add(array[i]);
		}
		
		for(int i = mid; i < array.length; i++){
			queue2.add(array[i]);
		}
		
		
		Stack<Integer> stack = new Stack<>();
		
		
		while(!queue1.isEmpty() || !queue2.isEmpty()){
			if(queue1.isEmpty()){
				stack.push(queue2.remove());
			}
			else if(queue2.isEmpty()){
				stack.push(queue1.remove());
			}
			else{
				stack.push(queue1.remove());
				stack.push(queue2.remove());
			}
				
		}
		
		for(int i : stack){
			System.out.println(i);
		}
	}
	
	
	
}
