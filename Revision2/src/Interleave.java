import java.util.Stack;

public class Interleave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Stack<Integer> elements = new Stack<Integer>();
        elements.push(1);
        elements.push(2);
        elements.push(3);
        elements.push(4);
        elements.push(5);
        elements.push(6);
        elements.push(7);
        elements.push(8);
        elements.push(9);
        elements.push(10);
        
        Stack<Integer> firsthalf = new Stack<Integer>();
        Stack<Integer> secondhalf = new Stack<Integer>();
        
        int counter = 5;
        
        
        for(int i = 0; i< counter; i++){
        	int temp = elements.pop();
        	secondhalf.push(temp);
        }
        
        for(int i = 0; i< counter; i++){
        	int temp = elements.pop();
        	firsthalf.push(temp);
        }
        
       for(int i =0; i<counter;i++){
    	   System.out.print(firsthalf.pop() + " " + secondhalf.pop() + " ");
       }
        
     
        
		
	}

}
