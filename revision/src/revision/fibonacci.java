package revision;

import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int first = 0;
         int second = 1;
         
         int next;
         Scanner scanner = new Scanner(System.in);
         
         System.out.println("Entern number of terms for fibonacci series: ");
         int numberOfTerms = scanner.nextInt();
         System.out.print(first +", " + second);
         for(int i = 3; i < numberOfTerms; i++){
        	 
        	 next = first + second;
        	 
        	 System.out.print(", " + next);
        	 first = second;
        	 second = next;
        	 
         }
         
	}

}
