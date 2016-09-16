
public class findPrime {
	public static String str ="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// isPrime(47);
		//System.out.println(str);

		for(int i = 2; i <= 100; i++){
			if(i == 2 || i == 3 || i == 5){
				System.out.println(i);
			}

			if(((i % 2) == 0) || ((i % 3) == 0) || ((i % 5) == 0)){

			}
			else 
				System.out.println(i);

		}

	}

	public static String isPrime(Integer x){

		if(x == 1){
			return str = str + x + " is not a prime";
		}

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
