package Arrays;

public class FindMissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Integer[] array = {10, 2, 3, 4, 5, 7, 8, 9, 1};
          int n = array.length;
          
          int temp = 0;
          
          for(int i = 1; i <= n +1; i++){
        	  temp = temp ^ i;
          }
          
          int temp2 = 0;
          
          for(int i = 0; i < array.length-1; i++){
        	temp2 = temp2 ^ array[i];  
          }
          
          int missing_number = temp ^ temp2;
          
          System.out.println(missing_number);
          
	}

}
