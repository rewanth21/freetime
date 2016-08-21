import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import org.omg.CORBA.SystemException;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("number of arrays?");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println("number of arrays: " + i);
		
		int[][] multD = new int[10][3];
		
		for(int j = 0; j < i; j++){
			
			System.out.println(j + ": array");
			for(int k=0;k<3;k++){
				
				multD[j][k] = sc.nextInt();
			}
			
			
		}
		Stack<Integer> stack = new Stack<Integer>();
		
		
		for(int h = 0; h < i; h++){
			for(int l = 0; l< 3 ; l++){
				
				stack.push(multD[h][l]);
			}
		}
       
		 if(stack == null || stack.isEmpty()){
	        	System.out.println("Stack is empty");
	        }
      
         
		  
		  Stack<Integer> helper = new Stack<Integer>();
	        helper.push(stack.pop());
      
	        
	        while(!stack.isEmpty()){
	     	   int temp = stack.pop();
	     	   while(!helper.isEmpty() && temp > helper.peek()){
	     		   stack.push(helper.pop());
	     	   }
	     	   helper.push(temp);
	        }
	        
	      
	        
	        for(Integer x : helper){
		     	   System.out.println(x);
		        }
		
		
		
		
		
		
	}

}
