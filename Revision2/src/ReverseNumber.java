import java.util.ArrayList;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 4;
		Integer[] numbers = new Integer[i];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 6;
        
        for(int j = numbers.length - 1; j >= 0; j--){
        	System.out.println(numbers[j]);
        }
	}

}
