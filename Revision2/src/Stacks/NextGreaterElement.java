package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer[] array = {4, 5, 2, 25};
                        // 0  1  2  3
        Stack<Integer> stack = new Stack<>();
        
        stack.push(array[0]);
       for(int i = 1; i< array.length;i++){
    	   while(!stack.isEmpty() && stack.peek() < array[i]){
    		   System.out.println(stack.pop() + " " + array[i]);
    	   }
    	   stack.push(array[i]);
       }
       
       while(!stack.isEmpty()){
    	   int top = (int) stack.pop();
    	   System.out.println(top + " " + "null");
       }
        
        
        
        
        
	}      
     
	

}
