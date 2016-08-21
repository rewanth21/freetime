import java.util.*;
import java.util.Map.Entry;



public class Map {


	public static void main(String []argh){
		HashMap<String, Integer> identity = new HashMap<>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++){
			String name = in.next();
			int phone = in.nextInt();
			identity.put(name, phone);
		}
		for (Entry<String, Integer> entry : identity.entrySet()) {
			  String key = entry.getKey();
			  Integer value = entry.getValue();
			  System.out.println(key + " " + value);
			}
		in.close();
		
	}	

}
