package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer[] array = {4, 5, 2, 25, 1, 6, 0,1};
                        // 0  1  2  3
        
       // nextGreater(array);
        
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
	
	static void nextGreater(Integer[] array){
		Stack<Integer> stack = new Stack<>();
		
		for(int i = array.length-1; i>=0; i--){
			stack.push(array[i]);
		}
		
		int i = 0;
		//System.out.println(array.length);
		while(i< array.length){
			
			if(stack.peek() < array[i]){
				//stack.pop();
				System.out.println(stack.peek() + " " + array[i] );
				stack.pop();
				//i++;
			}
			else if(stack.peek() >= array[i]){
			
				i++;
				//stack.pop();
			}
			
			if(i == array.length-1){
				System.out.println(array[i] + " null ");
			}
			
			
		}
		
	}
     
	

}
