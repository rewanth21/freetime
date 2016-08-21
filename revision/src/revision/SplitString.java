package revision;

public class SplitString {
    
   
	public static void main(String[] args) {
		int spliter = 2;
		String[] a1 = {"hello", "world", "rank"};
		split(a1, spliter);
	}
	
	public static void split(String[] newArray, int s){
		for(int i = 0; i < newArray.length; i++){
			char[] charArray = newArray[i].toCharArray();
			for(int j = 0; j < charArray.length; j++){
				if((j%2) == 0){
					System.out.print(charArray[j]);
				}
			}
			System.out.println(" ");
			
			for(int z = 0; z < charArray.length; z++){
				if((z%2) != 0){
					System.out.print(charArray[z]);
				}
			}
			
		}
	}
	
}
