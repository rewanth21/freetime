package Algorithms;

import java.util.ArrayList;

public class Pairs {

	static ArrayList<Character> chips2 = new ArrayList<>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		ArrayList<Character> chips = new ArrayList<>();
		chips2.add('A');
		chips2.add('A');
		chips2.add('B');
		chips2.add('B');
		chips2.add('B');
		chips2.add('A');
		chips2.add('B');
		chips2.add('B');

		
		chips.add('A');
		chips.add('A');
		chips.add('B');
		chips.add('B');
		chips.add('B');
		chips.add('A');
		chips.add('B');
		chips.add('B');
		chips.add('B');
		
		checkMajority(chips);

	}
	
	static int getfrequency(ArrayList<Character> chips, char m){
		int frequency = 0;
		for(char c : chips){
			if(c == m){
				frequency++;
			}
		}
		
		return frequency;
		
	}
	
	
	static char getmajorityelement(ArrayList<Character> chips){
		if(chips.size() == 2){
			if(chips.get(0) == chips.get(1))
				return chips.get(0);
			else{
				System.out.println("no majority element");
				
			}
			
			ArrayList<Character> temp = new ArrayList<>();
			
			for(int i = 0; i < chips.size();i++){
				if(chips.get(i) == chips.get(i+1)){
					temp.add(chips.get(i));
				}
				i = i + 1;
			}
			return getmajorityelement(temp);
				
			
		}
		
		
		return 0;
		
	}
	
	static void checkMajority(ArrayList<Character> chips){
		char m = getmajorityelement(chips);
		int freq = getfrequency(chips, m);
		
		if(freq > (chips.size()/2)+ 1){
			System.out.println(m);
			return;
		}
		else{
			System.out.println("no majority element");
			return;
		}
			
	}


	
	
	
	
	
	
	
	/*static boolean isitmajority(ArrayList<Character> chips2, int chip){
		int count = 0;
		for()
		
		return false;
	}
	
	static void findMajority(ArrayList<Character> chips, ArrayList<Character> chips2){
		

		int counter = 1;
		String newstring = "";

		//int size = chips.size();

		ArrayList<Character> temp = new ArrayList<Character>();
		System.out.println(chips.size());

		if(chips.size() <= 1){
			
			if(isitmajority(chips2, chips.get(0))){
				System.out.println(chips.get(0));
				return;
			}
			return;
			
		}

		if(chips.size() == 2){

			if(chips.get(0) == chips.get(1)){
				System.out.println(chips.get(0));
				return;
			}
			else{
				System.out.println("no majority element");
				return;
			}


		}

		for(int i = 0; i < chips.size(); i++){
			if(counter <=2){
				newstring = newstring + chips.get(i);
				System.out.println(newstring);
				counter++;

			}
			else{

				if(findequality(newstring)){
					System.out.println("Hello");
					temp.add(newstring.charAt(0));
					System.out.println(temp);
					newstring = "";
					counter = 1;
				}
				else{

					newstring = "";
					counter = 1;
				}
			}
		}

		if(temp.isEmpty() && findequality(newstring)){
			temp.add(newstring.charAt(0));

			newstring = "";
			counter = 1;
		}

		findMajority(temp);
	}	*/


	static boolean findequality(String s){
		if(s.length() == 1)
			return true;

		if(s.charAt(0) == s.charAt(1))
			return true;

		if(s.charAt(0) != s.charAt(1))
			return false;

		return false;
	}	
}
