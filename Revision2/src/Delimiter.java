
public class Delimiter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       removeSpaces("3 2 + 2 2 1 - 2 2 10 *");
	}

	
	public static void removeSpaces(String str){
		str = str.replaceAll("\\s+", "");
		System.out.println(str);
	}
}
