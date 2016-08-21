
public class FindString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		findSubstring("hackat", "rankhcacker");
	}
	
	public static void findSubstring(String s1, String s2){
		if(s2.contains(s1)){
			System.out.println(s1 + " is in " + s2);
		}
		else{
			System.out.println(s1 + " is not in " + s2);
		}
	}

}
