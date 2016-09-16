package Stacks;

import java.util.Stack;

public class NextGreaterElement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer[] array = {4, 5, 2, 25, 1, 6, 0,1};
         // 0  1  2  3

// nextGreater(array);

		 Stack<Integer> stack = new Stack<>();
		 
		 
		 stack.push(array[0]);
		 
		for(int i = 1; i < array.length; i++){
			while(!stack.isEmpty() && stack.peek() < array[i]){
				System.out.println(stack.pop() + " : " +  array[i]);
			}
			stack.push(array[i]);
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop() + " null ");
		}
		 
		 

	}

}
