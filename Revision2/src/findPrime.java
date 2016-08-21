
public class findPrime {
	public static String str ="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       isPrime(103);
       System.out.println(str);
	}
	
	public static String isPrime(Integer x){
		
		
		if(x == 2 || x == 3 || x == 5){
			return str = str + x + " is a prime number";
			
		}
		
		if(((x % 2) == 0) || ((x % 3) == 0) || ((x % 5) == 0)){
			return str = str + x + " is not a prime number";
		}
		else 
			return str = str + x + " is a prime number";
		
		
	}

}
