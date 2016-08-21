package Stacks;
import java.util.Stack;

public class Postfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println
		(postfixExpression("123*+5-"));
	}

	public static int perfoperation(char operation, int op1, int op2){
		
		if(operation == '+') return op1 + op2;
		else if(operation == '-') return op1 - op2;
		else if (operation == '*') return op1 * op2;
		else 
			return -1;
	}
	
	public static boolean isoperator(char c){
		if (c == '+' || c == '-' || c == '*' || c == '/'){
			return true;
		}
		else 
			return false;
	}
	
	public static boolean isnumeric(char c){
		if (c >= '0' && c <= '9'){
			return true;
		}
		else 
			return false;
	}
	
	public static int postfixExpression(String str){
		
		
		String str1 = str.replaceAll("\\s+", "");
		//System.out.println(str1);
		
		Stack<Integer> c = new Stack<Integer>();
		char s[] = str1.toCharArray();
		
		
		
		for(int i = 0; i<(s.length); i++){
			if(isnumeric(s[i])){
				//System.out.println(s[i]);
				int temp = Character.getNumericValue(s[i]);
				//System.out.println(temp);
				c.push(temp);
				
				//System.out.println(counter);
			}
			else if(isoperator(s[i])){
				//System.out.println(s[i]);
				int op2 = c.pop();
				int op1 = c.pop();
				int oper = perfoperation(s[i], op1, op2);
				c.push(oper);
			}
			
		}
		
		return c.pop();
		
	}
	
}
