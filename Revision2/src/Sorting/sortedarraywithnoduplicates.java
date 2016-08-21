package Sorting;

public class sortedarraywithnoduplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] array = {2, 2 , 2 ,3, 4, 5, 5, 6};
		
		
		int i = 0;
		int length = array.length;
		for(int j = 1; j < length; j++){
			if(array[i] != array[j]){
				array[++i] = array[j];
			}
		}
		
		
		int newlength = i + 1;
		System.out.println(newlength);
		
	}

}
