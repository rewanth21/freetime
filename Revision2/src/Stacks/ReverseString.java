package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter string");
        Scanner sc = new Scanner(System.in);
        
		String s = sc.nextLine();
		
		char[] characters = s.toCharArray();
		
	
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < characters.length;i++){
			stack.push(characters[i]);
		}
		
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
		
	}

}
