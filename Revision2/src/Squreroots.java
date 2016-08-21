import java.util.ArrayList;

public class Squreroots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rootsBetween(3, 22);
	}


	static void rootsBetween(int first, int last){
		int count = 0;
		ArrayList<Integer> array = new ArrayList<>();
		for(int i = first; i<=last;i++){
			array.add(i);
			
		}
			for(int j = 0; j<array.size(); j++){
				if(issqrt(array.get(j))){
                  count++;
				}

		}
		System.out.println(count);
}
	
	static boolean issqrt(int i){
		int sqrt = (int) Math.sqrt(i);
		if(sqrt*sqrt == i){
			System.out.println(i);
			return true;
		}
		else 
			return false;
	}
	
}