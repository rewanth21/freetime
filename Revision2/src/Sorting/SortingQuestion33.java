package Sorting;

import java.lang.reflect.Array;

public class SortingQuestion33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //There are two sorted arrays A and B. First one is m + n size with m elements
		//and second is n size with n elements. Sort them by added array B into array A.
		
		Integer[] array1 = {1, 14, 20, 23, 0 , 0, 0, 0, 0};
		Integer[] array2 = {2, 12, 19, 22, 26};
		
		
		int i = 0;
		int j = 0;
		
	
		
		while(i < array1.length){
			
			if(array2[j] > array2[j+1]){
				array2[j+1] = array2[j];
			}
			
			if(array1[i] > array2[j]){
				int temp = array1[i];
				array1[i] = array2[j];
				array2[j] = temp;
				i++;
			}
			else{
				int temp = array1[i];
				array1[i] = array2[j];
				array2[j] = temp;
				j++;
			}
			
			
			
		}
		
		for(Integer k : array1){
			System.out.print(k + " ");
		}
		
		
	}

}
