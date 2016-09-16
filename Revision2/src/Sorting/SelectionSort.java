package Sorting;

public class SelectionSort {
	
	public static int[] doSelectionSort(int[] arr, int array_length){

		for (int i = 0; i < array_length - 1; i++)
		{
			int iMin = i;
			for (int j = i + 1; j < array_length; j++)
				if (arr[j] < arr[iMin])
					iMin = j;

			int temp = arr[iMin]; 
			arr[iMin] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

	public static void main(String a[]){

		int[] arr1 = {10,34,2,56,7,67,88,42};
		 doSelectionSort(arr1, arr1.length);
		for(int i:arr1){
			System.out.print(i);
			System.out.print(", ");
		}
	}
}
