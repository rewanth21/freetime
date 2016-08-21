package Trees;

import java.util.ArrayList;
import java.util.Collections;

public class BTreetoBBT {
	 static int counter = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.left.left.right = new Node(6);
		root.left.left.right.right = new Node(8);
		root.right.left = new Node(5);
		root.right.left.right = new Node(7);
		
		
		ArrayList<Integer> list = new ArrayList<>();
		//Integer[] newarray = new Integer[1];
		inOrder(root, list);
		Collections.sort(list);
		
		toBST(root, list);
		print(root);
		
		
	}

	  

	static void toBST(Node root, ArrayList<Integer> list) {
		if(root == null)
			return;
		
		toBST(root.left, list);
		root.data =list.get(counter);
		counter++;
		
		toBST(root.right, list);
		
		
		
		
	}



	 static void print(Node root) {
		if(root == null)
			return;
		
		print(root.left);
		System.out.print(root.data + " ");
		print(root.right);
		
	}



	static void inOrder(Node root, ArrayList<Integer> list) {
		if(root == null)
			return;
		
		inOrder(root.left, list);
		list.add(root.data);
		inOrder(root.right, list);
		
	}

}
