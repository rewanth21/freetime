package Stacks;
import java.util.Stack;

public class StackExpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
       if(Expression("[{()}]")){
    	   System.out.println("balanced");
       }
       else 
    	   System.out.println("not balanced");
	}
	
	public static boolean ArePair(char opening, char closing){

		if(opening == '(' && closing == ')') return true;
		else if(opening == '{' && closing == '}') return true;
		else if(opening == '[' && closing == ']') return true;
		return false;
		
	}
	
	public static boolean Expression(String str){
		
		char s[] = str.toCharArray();
		Stack<Character> c = new Stack<Character>();
		
		for(int i = 0; i < (str.length()); i++){
			if((s[i] == '(') || (s[i] == '{') || (s[i] == '[')){
				c.push(s[i]);
				
			}
			else if((s[i] == ')') || (s[i] == '}') || (s[i] == ']')){
				if(c.isEmpty() || (!ArePair(c.peek(), s[i]))){
					System.out.println(s[i]);
					System.out.println(c.peek());

					return false;
					
				}
				else{
					c.pop();
				}
			}
		}
		
		if(c.isEmpty()){
			return true;
		}
		else
			return false;
	}
	
}
