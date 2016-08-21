package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinDepthsum {
	static ArrayList<Integer> list = new ArrayList<>();
	static int total = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(7);
		root.left.right = new Node(3);
		//root.left.left.right = new Node(6);
		//root.left.left.right.right = new Node(8);
		root.right.left = new Node(9);
		root.right.right = new Node(4);
		root.right.left.left = new Node(8);
		root.right.left.right = new Node(3);
		
		int depth = levels(root);
		System.out.println(depth);
		
		getAllNodesAtDepth(root, depth);
		System.out.println();
		
		for(Integer i : list){
			total = total + i;
		}
		
		System.out.println(total);
	}
	
	
	static void getAllNodesAtDepth(Node root, int depth){
		if(root == null)
			return;
		int counter = 1;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		
		while(!queue.isEmpty()){
			Node current = queue.poll();
			if(current != null){
				if(current.left == null && current.right == null & counter == depth){
					list.add(current.data);
				}
				
				if(current.left != null)
					queue.offer(current.left);
				
				if(current.right != null)
					queue.offer(current.right);
			}
			else
			{
				if(!queue.isEmpty()){
					counter++;
					queue.offer(null);
				}
			}
		}
		
	}
	
	static int levels(Node root){
		if (root == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		int count = 1;
		
		while(!queue.isEmpty()){
			Node currentnode = queue.poll();
			if(currentnode != null){
				if(currentnode.left == null && currentnode.right == null){
					System.out.println(currentnode.data);
					return count;
				}
				
				if(currentnode.left != null)
					queue.offer(currentnode.left);
				
				if(currentnode.right != null)
					queue.offer(currentnode.right);
				
			}
			else{
				if(!queue.isEmpty()){
					count++;
					queue.offer(null);
				}
			}
		}
		
		return count;
		
	}

	
	
}
