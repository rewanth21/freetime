public class SplitString {


	public static void main(String[] args) {
		
		String[] a1 = {"Hacker", "Rank", "newbie", "score"};
		split(a1);
	}

	public static void split(String[] newArray){
		String even = "";
		String odd = "";
		
		
		for (int i = 0; i<newArray.length; i++){
			char[] charArray = newArray[i].toCharArray();
			for(int j = 0; j < charArray.length; j++){
				
					if((j%2) == 0) {
						//System.out.print(charArray[j]);
						
						even  = even + charArray[j];
					}
					else 
						odd = odd + charArray[j];
					
			}
			System.out.print(even + " " + odd);
			even = "";
			odd = "";
			System.out.println("");
			
		}
	}
}
		
		
		
	
	


