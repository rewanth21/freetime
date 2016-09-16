package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightIterative {

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

		height(root);


	}

	static void height(Node root){
		int counter = 0;
		Node temp = null;
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()){
			Node current = queue.poll();
			if(current != null){
				System.out.println(current.data);

				if(current.left != null)
					queue.offer(current.left);

				if(current.right != null)
					queue.offer(current.right);
			}

			else if(!queue.isEmpty()){
				if(current == null){
					queue.offer(null);
					counter++;
				}

			}
		}
		System.out.println(counter);

		//findHeight(root, temp);
	}







}


