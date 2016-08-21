package LinkedList;

import java.util.LinkedList;

public class AddTwoLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		

		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		
		
		addLL(list1);
		
	}
	
	static void addLL(LinkedList<Integer> list1){
		
		LinkedList<Integer> list2 = new LinkedList<Integer>();

		
		
		for(int i = 0; i < list1.size(); i++){
			
			
			if(list1.get(i)%2 == 0){
				list2.add(list1.get(i));
				
                list1.remove(i);
			}
			
			
			
		}
		
		for(int i = 0 ; i < list1.size();i++){
			list2.add(list1.get(i));
			
		}
		
		for(Integer j : list2){
			System.out.println(j);
		}
		
	}
	
	

}
