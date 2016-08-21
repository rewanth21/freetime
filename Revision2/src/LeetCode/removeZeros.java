package LeetCode;

import java.awt.List;
import java.util.ArrayList;

public class removeZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Integer[] array = {1,2,3,4,0,4,0,0,9,0};
     ArrayList<Integer> list = new ArrayList<Integer>();
      
      
      for(int i = 0; i<array.length;i++){
    	  if(array[i] != 0){
    		  list.add(array[i]);
    	  }
      }
      
      
      
      
      for(Integer k : list){
    	  System.out.print(k + " ");
      }
      
	}

}
