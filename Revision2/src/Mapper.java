
import java.util.*;
import java.util.Map.Entry;

public class Mapper{

     public static void main(String []argh){
		HashMap<String, Integer> identity = new HashMap<>();
		String s = "mondo";
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++){
			String name = in.next();
			int phone = in.nextInt();
			identity.put(name, phone);
		}
			
		in.close();
		for (Entry<String, Integer> entry : identity.entrySet()) {
			  String key = entry.getKey();
			  Integer value = entry.getValue();
			  if (s.equals(key)){
			      System.out.println(key + " = " + value);
			  }
			  else
			     System.out.println("Not found");
      }
			 }
		
	}

