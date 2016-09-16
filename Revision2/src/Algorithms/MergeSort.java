package Algorithms;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] Array = {2,2,2,2,2,2,2,2,5,1,0,12,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,4,4,4,4,4,6,6,6,6,6,6,6,6,6,6,6};
		int[] Array2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,3,3,3,3,3,3,3};

		mergeSort(Array);


		findMode(Array);
	}

	static void findMode(int[] array){


		int i = 0;
		int lastnumber = array[0];
		int countOfPreviousNumber = 1;
		int countOfCurrentNumber = 1;
		int maxelement = array[0];

		for(int j = 1; j < array.length; j++){
			if(array[j] != lastnumber){
				lastnumber = array[j];
				if(countOfCurrentNumber > countOfPreviousNumber){
					countOfPreviousNumber = countOfCurrentNumber;
					countOfCurrentNumber = 1;
					maxelement = array[j-1];
				}
				else{
					countOfCurrentNumber = 1;
				}			
			}
			else{
				countOfCurrentNumber++;
			}
		}

		if(countOfCurrentNumber>countOfPreviousNumber){
			countOfPreviousNumber = countOfCurrentNumber;
			
		}

		System.out.println("number of times :" + countOfPreviousNumber);
		System.out.println("element :" + maxelement);
	}

	public static void mergeSort(int[] inputArray) {
		int size = inputArray.length;
		if (size < 2)
			return;
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		for (int i = 0; i < mid; i++) {
			left[i] = inputArray[i];

		}
		for (int i = mid; i < size; i++) {
			right[i - mid] = inputArray[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, inputArray);
	}

	public static void merge(int[] left, int[] right, int[] arr) {
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0, j = 0, k = 0;
		while (i < leftSize && j < rightSize) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
				k++;
			} else {
				arr[k] = right[j];
				k++;
				j++;
			}
		}
		while (i < leftSize) {
			arr[k] = left[i];
			k++;
			i++;
		}
		while (j < rightSize) {
			arr[k] = right[j];
			k++;
			j++;
		}
	}

}
