package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNode {

	static int deepestlevel;
	int value;
	static int deepestnode = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		//root.left.left = new Node(4);
		//root.left.right = new Node(5);
		//root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);
		//root.right.right.right.left = new Node(10);
		
		
		
		findIt(root);
		
		
		
	/*	DeepestNode dp = new DeepestNode();
		System.out.println("Deepest child is: " + dp.Deep(root));
		
		System.out.println(deepestlevel);*/
		System.out.println();
		System.out.println("deepest node is : " + deepestnode);
	}
	
	
	static void findIt(Node root){
		if (root == null){
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			deepestnode = queue.peek().data;
			Node current = queue.poll();
			System.out.print(current.data);
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right!= null){
				queue.add(current.right);
			}
		}
	}
	
	
/*	public int Deep(Node root){
		find(root, 0);
		return value;
	}
	
	
	public void find(Node root, int level){
		if(root!=null){
			find(root.left, ++level);
			if(level>deepestlevel){
				value = root.data;
				deepestlevel = level;
			}
			find(root.right, level);
		}
		
	}*/
	
	

}
