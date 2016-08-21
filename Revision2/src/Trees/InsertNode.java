package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class InsertNode {

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
		
		
		insert(root, -9);
		levelOrder(root);
	}

	static void levelOrder(Node root){
		if(root == null){
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			Node current = queue.poll();
			System.out.print(current.data + " ");
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right != null){
				queue.add(current.right);
			}
		}
		
	}
	
	/* A recursive function to insert a new key in BST */
    static Node insert(Node root, int key) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
		
		
		
}

