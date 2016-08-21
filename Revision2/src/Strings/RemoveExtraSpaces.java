package Strings;

import java.util.ArrayList;

public class RemoveExtraSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "   abc c  ded  ";
		int stringLength = s.length();


		int leftcounter = 0;
		int rightcounter = 0;

		for(int i = 0; i < s.length();i++){
			if(s.charAt(i) != ' '){
				break;
			}
			leftcounter++;

		}
		int i = 0;
		while(i < leftcounter){
			i++;
		}

		String newstring = s.substring(i);

		for(int k = s.length()-1; k >= 0;k--){
			if(s.charAt(k) != ' '){
				break;
			}
			rightcounter++;

		}


		int j = 0;
		for(int k = newstring.length()-1; k >= 0;k--){
			if(j<rightcounter){
				j++;
			}

		}
		String reversed = "";
		for(int k = newstring.length()-1; k >= 0;k--){
			reversed = reversed + newstring.charAt(k);
		}

		String newnewstring = reversed.substring(j);

		reversed = "";

		for(int k = newnewstring.length()-1; k >= 0;k--){
			reversed = reversed + newnewstring.charAt(k);
		}
		String newstring1 = "  abc c c  ded  ";
		String[] correctedString = newstring1.split("");


		//System.out.println(correctedString);


		ArrayList<String> list = new ArrayList<String>();
		String stringer = "";
		int spacecounter = 0;

		int counter = 0;
		/* while(counter < correctedString.length()){
	   if(correctedString.charAt(counter) != ' ' && spacecounter == 0){
		   stringer = stringer + correctedString.charAt(counter);
		   counter++;
	   }

	   if(correctedString.charAt(counter) == ' '){
		   counter++;
	   }
	   else{
		   list.add(stringer);
		   stringer = "";
	   }



   }*/

		for(int f = 0; f < correctedString.length; f++){
			if(!correctedString[f].equals(" ")){
				//System.out.println(correctedString[f]);
				stringer = stringer + correctedString[f];
			}

			if(correctedString[f].equals(" ")||f==correctedString.length-1){
				//System.out.println("found space");
				//System.out.println("stringer:"+stringer);
				if(stringer!="")
					list.add(stringer);
				stringer="";

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
