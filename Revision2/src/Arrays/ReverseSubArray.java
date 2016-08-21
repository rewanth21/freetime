package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {1,2,3,4,5,6,7,8,9,10,11};
		ArrayList<Integer> list = new ArrayList<>();


		int k = 3;


		int n =array.length;

		int counter = 1;

		for(int i = 0; i<n; i++){
			if(counter <= k ){
				list.add(array[i]); 
				counter++;
			}
			else{
				reverse(list);
				counter = 1;
				list.clear();
				i--;
			}

		}  
		reverse(list);

	}

	static void reverse(ArrayList<Integer> list){

		for(int i = list.size() -1; i>= 0;i--){
			System.out.print(list.get(i) + " ");
		}


		//maxelement(list);


	}


	static void maxelement(ArrayList<Integer> list){
		int max = 0;
		for(int i = 0; i < list.size();i++){
			if(max < list.get(i)){
				max = list.get(i);
			}
		}
		System.out.println(max);
	}
}
