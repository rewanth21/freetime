
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PalindromeCheck {

	
    static Stack<Character> stack = new Stack<>();
static Queue<Character> queue = new LinkedList<>();


	
	 public static void main(String[] args) {
	        String input = "saSas";
          // input=  input.toLowerCase();
	        
	        
	        Pattern regex = Pattern.compile("[$&+,:;=?@#|0-9]");
	        Matcher matcher = regex.matcher(input);
	        
	        if(matcher.find()){
	        	System.out.println("there should be no special characters or numbers");
	        	return;
	        }
	        
	        
           String result = input.replaceAll("[^a-zA-Z]+","");
           //for digits to exist as well
           //String result = input.replaceAll("[^a-zA-Z0-9]+","");
           
	        // Convert input String to an array of characters:
	        char[] s = result.toCharArray();
            
	        // Create a Solution object:
	       

	        // Enqueue/Push all chars to their respective data structures:
	        for (char c : s) {
	            stack.push(c);
	            queue.add(c);
	        }

	        
	        // Pop/Dequeue the chars at the head of both data structures and compare them:
	        boolean isPalindrome = true;
	        for (int i = 0; i < s.length/2; i++) {
	            if (stack.pop() != queue.remove()) {
	                isPalindrome = false;                
	                break;
	            }
	        }

	        //Finally, print whether string s is palindrome or not.
	        System.out.println( "The word, " + result + ", is " 
	                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
	    }
	}
	
	
	

