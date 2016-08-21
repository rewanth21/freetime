package Stacks;

import java.util.ArrayList;

public class Operations {

	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public Operations(int s){
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	
	public long push(long j){
		return stackArray[++top] = j;
	}
	
	public long pop(){
		return stackArray[top--];
	}
	
	public long peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == maxSize - 1);
	}
	
	
	
	public static void main(String[] args){
		Operations theStack = new Operations(10);
		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);
		theStack.push(10);
		theStack.push(5);
		System.out.println(theStack.peek());
		while(!theStack.isEmpty()){
			System.out.println(theStack.pop());
		}
		
	}
	
}
