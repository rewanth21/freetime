package Strings;

import java.util.ArrayList;

public class RemoveExtraSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String newstring1 = " abc   we    ds  sx  ";
		String[] correctedString = newstring1.split("");


		ArrayList<String> list = new ArrayList<String>();
		String stringer = "";


		for(int f = 0; f < correctedString.length; f++){
			if(!correctedString[f].equals(" ")){
				stringer = stringer + correctedString[f];
			}

			if(correctedString[f].equals(" ")){	
				if(stringer!=""){
					if(f == correctedString.length-1){
						System.out.print(stringer);
						stringer= "";
					}
					else{
						System.out.print(stringer + " ");
						stringer = "";
					}
				}
					//list.add(stringer);
				//stringer="";
			}
		}


		for(int x = 0; x < list.size();x++){
			if(x == list.size()-1){
				System.out.print(list.get(x));
			}
			else
				System.out.print(list.get(x) + " ");
		}


	}





}
