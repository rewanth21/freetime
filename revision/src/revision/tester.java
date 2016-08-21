package revision;

public class tester {

	public static void main(String[] args) {
	
		Integer[] a1 = {1, 2, 3, 4, 6, 7, 8};
		Integer[] a2 = {5, 7, 8, 11, 12, 13, 14, 15, 16};
		int j = 0, k = 0;
		
		int c [] = new int[a1.length+a2.length];
		
		
		
		
		for(int i = 0; i<c.length; i++){
			if(j<a1.length && k < a2.length){
				
				if(a2[k] < a1[j]){
					c[i] = a2[k];
					k++;
				}
				else{
					c[i] = a1[j];
					j++;
				}
				
				
			}
			
			else if(k < a2.length){
			    c[i] = a2[k];
			    k++;
			}
			else{
				c[i] = a1[j];
				j++;
			}
			
			    
		}
		
		for(int i = 0; i<c.length;i++){
			System.out.println(c[i]);
		}
		
	}
}

