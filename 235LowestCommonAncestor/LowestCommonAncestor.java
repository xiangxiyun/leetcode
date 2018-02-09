import java.util.*;

public class LowestCommonAncestor{
	public static void main(String[] args){

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left, p, q);
		else if(root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right, p, q);
		else return root;
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		while((root.val - p.val)*(root.val-q.val) > 0){
			root = p.val < root.val? root.left: root.right;
		}

		return root
	}
}


public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}