public class InvertBinaryTree{
	public static void main(String[] args){

	}

    public static TreeNode invertTree(TreeNode root) {
    	if(root == null)
    		return root;
    	ArrayDeque<TreeNode> queue = new ArrayDeque<>();

    	queue.add(root);
    	while(!queue.isEmpty()){
    		TreeNode node = queue.poll();
    		TreeNode temp = node.left;
    		node.left = node.right;
    		node.right = temp;
    		if(node.left!=null)
    			queue.add(node.left);
    		if(node.right != null)
    			queue.add(node.right);
    	}
    	return root;
    }
}