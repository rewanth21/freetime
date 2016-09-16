package Stacks;

import java.util.Stack;

public class ReverseStackRecurse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
	
		
		recurse(stack);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	
	static void recurse(Stack<Integer> stack){
		
		if(stack.isEmpty())
			return;
		
		
			 int temp = stack.pop();
		
		
		recurse(stack);
		insert(stack, temp);
		
	}
	
	
	static void insert(Stack<Integer> stack, int temp){
		
		if(stack.isEmpty()){
			stack.push(temp);
			return;
		}
		
			int temp1 = stack.pop();
			insert(stack, temp);
		    stack.push(temp1);
		
		
		
		
	}

}
