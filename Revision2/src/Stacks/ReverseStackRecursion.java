package Stacks;

import java.util.Stack;

public class ReverseStackRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Stack<Integer> stack = new Stack<>();
       
       stack.push(4);
       stack.push(5);
       stack.push(1);
       stack.push(2);
       stack.push(3);
       
       stack.push(7);
       
       
       
       reverse(stack);
       
       while(!stack.isEmpty()){
    	   System.out.println(stack.pop());
       }
       
       System.out.println();
       
	}
	
	static void reverse(Stack<Integer> stack){
		while(!stack.isEmpty()){
			int temp = stack.pop();
			reverse(stack);
			System.out.println(temp);
			
		}
	}

	
}
