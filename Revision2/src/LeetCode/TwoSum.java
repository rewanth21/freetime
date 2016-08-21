package LeetCode;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int target = 22;
       Integer[] array = {2, 7, 11, 15};
       
       getTarget(target, array);
	}
	
	static void getTarget(int target, Integer[] array){
		
		for(int i = 0; i < array.length-1; i++){
			for(int j = i+1; j < array.length;j++){
				if(array[i] + array[j] == target){
					System.out.println(array[i] + " + " + array[j] + " = " + target);
				}
			}
			
				
		}
		
	}

}
