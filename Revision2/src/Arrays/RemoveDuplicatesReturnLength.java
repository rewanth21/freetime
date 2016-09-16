package Arrays;

public class RemoveDuplicatesReturnLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Integer[] array = new Integer[7];
      
      array[0]= 1;
      array[1]= 3;
      array[2]= 3;
      array[3]= 3;
      array[4]= 4;
      array[5]= 4;
      array[6]= 5;
      
      int i = 0;
      
      for(int j = 1; j < array.length-1; j++){
    	  if(array[i] != array[j]){
    		  array[i+1] = array[j];
    		  i++;
    	  }
    	  
    	
    	 
      }
      System.out.println(i);
     
      
      
	}

}
