package Arrays;

import java.util.ArrayList;

public class NextMinNextMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Integer[] array = {1,2,3,4,5,6,7,8,9,10};
       Integer[] newarray = new Integer[array.length];
       ArrayList<Integer> list = new ArrayList<>();
       
       int low = 0;
       int high = array.length - 1;
       
       int mid = (low + high)/2;
       
       while(low<=mid && high >=mid){
    	   if(low == high){
    		   list.add(array[low]);
    		   break;
    	   }
    	   
    	   list.add(array[low]);
    	   list.add(array[high]);
    	   low++;
    	   high--;
       }
       
       System.out.print(list);
	}

}
