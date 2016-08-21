package Arrays;

import java.util.Arrays;

public class MinDiffBetweenTwoElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] array = {2,4,5,6,8, -17,2,5,10};
		
		int diff = 5000;
		Arrays.sort(array);
		
		
		for(int i = 0; i < array.length-1;i++){
			if(array[i+1] - array[i] < diff){
				diff = array[i+1] - array[i];
				
			}
			
			
		}
	   
		System.out.println(diff);
	}

}
