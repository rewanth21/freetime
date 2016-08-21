package Stacks;
import java.util.ArrayList;
import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] iarray = {-1, 0, 4, 6, -2, 1};
		
        findMinimum(iarray);
	}
	
	
	public static int findMinimum(Integer[] intarray){
		
		
		
		
		Stack<Integer> top = new Stack<Integer>();
		Stack<Integer> min = new Stack<Integer>();
		
	    for(int i = 0; i < intarray.length; i++){
	    	if(min.isEmpty()){
	    		top.push(intarray[i]);
	    		min.push(intarray[i]);
	    	}
	    	else
	    		top.push(intarray[i]);
	    	
	    	if(top.peek() <= min.peek()){
	    		System.out.println(min.push(top.peek()));
	    	}
	    }
	    
	    System.out.println("");
	    for(Integer s4 : top){
	    	System.out.println(s4);
	    }
	
	  
	
		
		return 0;
		
	}

}
