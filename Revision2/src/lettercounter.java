
public class lettercounter {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        countLetters("aabb");
        
	}
	
	public static void countLetters(String str1){
		  String s = "";
		  char last = str1.charAt(0);
		  
		  int counter = 1;
		  
		  for(int i = 1; i < str1.length(); i++){
			  if(str1.charAt(i) == last){
				  
				  counter++;
				  
			  }
			  else{
				  s += last + "" + counter;
				  last = str1.charAt(i);
				  counter = 1;
			  }
		  }
		  System.out.println(s + last + counter);
		
	}

}
