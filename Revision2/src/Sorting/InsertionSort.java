package Sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    int[] arr1 = {10,34,2,56,7,67,88,42};
	        int[] arr2 = doInsertionSort(arr1);
	        for(int i:arr2){
	            System.out.print(i);
	            System.out.print(", ");
	        }
	    }
	     
	    public static int[] doInsertionSort(int[] input){
	         
	        int value;
	        int hole;
	        for(int i = 1; i < input.length;i++){
	        	value = input[i];
	        	 hole = i;
	        	 while(hole>0 && input[hole -1] > value){
	        		 input[hole] = input[hole - 1];
	        		 hole = hole - 1;
	        	 }
	        	 input[hole] = value;
	        	
	        }
	        return input;
	
	}

}
