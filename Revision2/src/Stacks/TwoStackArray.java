package Stacks;

import java.util.Stack;

public class TwoStackArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int midpoint = array.length/2;
        
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        
        
        for(int i = 0; i < midpoint; i++){
        	stack1.push(array[i]);
        }
        
        for(int i = midpoint; i < array.length; i++){
        	stack2.push(array[i]);
        }
        
        
        while(!stack1.isEmpty()){
        	System.out.println(stack1.pop());
        }
        
        System.out.println();
        
        while(!stack2.isEmpty()){
        	System.out.println(stack2.pop());
        }
        
	}

}
