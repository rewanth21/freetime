package Stacks;
import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           
		reverseWord("hello");
	}
	
	public static void reverseWord(String str){
	   char newstr[] = str.toCharArray();
	  int counter = 0;
	   
	   Stack<Character> c = new Stack<Character>();
	   Stack<Character> c1 = new Stack<Character>();
	   
	   for(int i = 0; i<newstr.length;i++){
		   c.push(newstr[i]);
		   counter++;
	   }
	   
	  
	   
	   for(int i1 = 0; i1<counter;i1++){
		   c1.push(c.pop());
		 }
		
	   
	   for(char c2: c1){
		   System.out.print(c2);
	   }
	}

}
