package revision;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Intersection {
	

	public static void findCommonElements(int a1[],int a2[]){
		if((a1.length == 0) || (a2.length == 0)){
			return;
		}
		for(int i = 0, j = 0; i < a1.length-1 && j<a2.length-1;){
			if(a1[i] == a2[j]){
				System.out.println(a1[i]);
				i++; j++;
			}
			else if (a1[i] < a2[j]){
				i++;
			}
			else 
				j++;
		}
	}

	public static void main(String[] args) {
		int a1[] =new int[]{1,2,3,3,3,4,5,5,6,6};
		int a2[] = new int[]{2,3,3,3,3,4,5,6};
		findCommonElements(a1, a2);
	}

}

