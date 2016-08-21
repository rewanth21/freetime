package Stacks;
import java.util.Stack;

public class SortUsingStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Stack<Integer> S1 = new Stack<Integer>();
        
        
        S1.push(1);
        S1.push(0);
        S1.push(3);
        S1.push(4);
        
        if(S1 == null || S1.isEmpty()){
        	System.out.println("Stack is empty");
        }
        
        
        Stack<Integer> helper = new Stack<Integer>();
        helper.push(S1.pop());
        
       while(!S1.isEmpty()){
    	   int temp = S1.pop();
    	   while(!helper.isEmpty() && temp > helper.peek()){
    		   S1.push(helper.pop());
    	   }
    	   helper.push(temp);
       }
       
    
       
       for(Integer i : helper){
    	   System.out.println(i);
       }
       
        
        
        
	}

}
