
public class Recursion {
   static int store = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(reverse(5));
	}
	
	public static int reverse(int num){
		if (num == 1){
			return store;
		}
		else{
			store = store * num;
			reverse(num - 1);
		}
		
		return store;
		
	}

}
