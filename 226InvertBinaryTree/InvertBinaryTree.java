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
    		
    	}
    }
}