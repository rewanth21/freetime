package LeetCode;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Random rand = new Random();
       int numberToGuess = rand.nextInt(100);
       int numberOfTries = 0;
       Scanner input = new Scanner(System.in);
       int guess;
       boolean win = false;
       
       
       
       while(win == false){
    	   System.out.println("Guess a number between 1 and 100: ");
    	   guess = input.nextInt();
    	   numberOfTries++;
    	   
    	   
    	   if(guess == numberToGuess){
    		   System.out.println("found it");
    		   System.out.println(numberOfTries);
    		   return;
    	   }
    	   else if(guess < numberToGuess){
    		   System.out.println("guess is too low");
    		  
    	   }
    	   else if(guess > numberToGuess){
    		   System.out.println("guess is too high");
    		   
    	   }
       }
       
	}

}
