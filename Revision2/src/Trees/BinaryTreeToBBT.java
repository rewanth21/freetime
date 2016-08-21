package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinaryTreeToBBT {

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
		
		ArrayList<Integer> inorder = new ArrayList<>();
		int[] index = new int[1];
		
		
		PrintInOrder(root);
		createInorderArray(root, inorder, index);
		Collections.sort(inorder);
		index[0] = 0;
		changeNodeValues(root, inorder, index);
		System.out.println();
		PrintInOrder(root);
	}
	
	public static void PrintInOrder(Node root){
		if(root == null)
			return;
		
		PrintInOrder(root.left);
		System.out.println(root.data);
		PrintInOrder(root.right);
	}
	
	public static void createInorderArray(Node currentnode, ArrayList<Integer> inorder, int[] index){
		if(currentnode == null)
			return;
		
		createInorderArray(currentnode.left, inorder, index);
		inorder.add(currentnode.data);
		index[0] += 1;
		createInorderArray(currentnode.right, inorder, index);
		
	}
	
	public static void changeNodeValues(Node currentnode,ArrayList<Integer> inorder, int[] index){
		if(currentnode == null)
			return;
		changeNodeValues(currentnode.left, inorder, index);
		currentnode.data = inorder.get(index[0]);
		index[0] +=1;
		changeNodeValues(currentnode.right, inorder, index);
	}
	
	
	

}
