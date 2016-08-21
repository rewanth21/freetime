package Stacks;
import java.util.Stack;

public class SortingStackRecursion {
///THIS PROGRAM IS NOT DONE///
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> S1 = new Stack<Integer>();
		S1.push(1);
		S1.push(2);
		S1.push(3);
		for(int i : S1){
			System.out.println(i);
		}
		recurse(S1);
		
	}
	
	public static void recurse(Stack<Integer> s){
	    if(!s.isEmpty()){
	    	int temp = s.pop();
	    	recurse(s);
	    	System.out.println(temp);
	    	
	    }
		
		
	
	

	}

}
