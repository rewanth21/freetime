package Trees;

public class nextrightnull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<node> queue = new linkedlist<>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()){
			Node temp = root;
			node root = queue.pop();
			if(root == null){
				temp.nextright = null;
				if(temp.left != null){
					queue.add(temp.left);
				}
				if(temp.right != null){
					queue.add(temp.right);
				}
			}
			else
			{
				if(root != null){
					if(temp == null){
						queue.add(nextright);
					}
					else{
						if(temp.left !=null){
							queue.add(temp.left);
						}
						if(temp.right != null){
							queue.add(temp.right);
						}
						temp.nextright = root;
					}
				}
			}
		}
		
		
	}

}
