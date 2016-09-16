package Arrays;

public class FirstOccurenceOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Integer[] array= {1,2,3,3,3,3,3,3,3,3,3,4,5,6,7,7,10,11};
       Integer number = 3;
       
       int firstOccurence = FirstOccurence(array, number);
       int lastOccurence = LastOccurence(array, number);
       int totalOccurence = lastOccurence - firstOccurence + 1;
       
       System.out.println("First occurence of " + number + " is at index " + firstOccurence);
       System.out.println("Last occurence of " + number + " is at index " + lastOccurence);
       
       System.out.println("Number of times " + number + " has occurred is " + totalOccurence);
       
      
       
    }
	
	static int FirstOccurence(Integer[] array, Integer number)
	{
		int low = 0;
		int high = array.length-1;
		int mid;
		
		int result = -1;
		
		while(low<=high){
			
			mid = (low + high)/2;
			if(array[mid] == number){
				result = mid;
				high = mid-1;
			}
			else if(array[mid] > number){
				high = mid -1;
			}
			else
				low = mid + 1;
		}
		
		return result;
		
		
	}
	
	static int LastOccurence(Integer[] array, Integer number)
	{
		int low = 0;
		int high = array.length-1;
		int mid;
		
		int result = -1;
		
		while(low<=high){
			
			mid = (low + high)/2;
			if(array[mid] == number){
				result = mid;
				low = mid + 1;
			}
			else if(array[mid] > number){
				high = mid -1;
			}
			else
				low = mid + 1;
		}
		
		return result;
		
		
	}
	
}
