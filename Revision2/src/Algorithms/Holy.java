package Algorithms;

import java.util.Date;

public class Holy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Integer i = 0;
         
         
         long lStartTime = new Date().getTime();
         System.out.println(getNthHolyNumber(i));
         long lEndTime = new Date().getTime();
         
         long difference = lEndTime - lStartTime;
         System.out.println("Elapsed milliseconds: " + difference);
         
	}
	
	static int getNthHolyNumber(int n){
		int i = 1;
		int curr = 3;
		while(i != (n+1)){
			if(isHoly(curr)){
				i = i + 1;
				
			}
			curr = curr + 1;
		}
		return curr - 1;
	}
	
	
	static boolean isHoly(Integer n){
		if(n < 3){
			return false;
		}
		while(n%7 == 0){
			n = n/7;			
		}
		while(n%3 == 0){
			n = n/3;
		}
		
		return n == 1;
		
	}

}
