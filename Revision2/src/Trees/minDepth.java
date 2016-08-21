package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class minDepth {

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
		
		
		System.out.println(levels(root));
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
