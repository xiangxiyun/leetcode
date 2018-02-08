import java.util.*;

public class Codec {
	/*https://discuss.leetcode.com/topic/28029/easy-to-understand-java-solution*/
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		String res = serialize(root);
		System.out.println(res);
		TreeNode new_root = deserialize(res);

		LinkedList<TreeNode> queue = new LinkedList<>();
    	queue.add(new_root);

    	while(!queue.isEmpty()){
    		TreeNode node = queue.poll();
    		if(node!=null){
    			System.out.println(node.val);
    			queue.add(node.left);
    			queue.add(node.right);
    		}else{
    			System.out.println("null");
    		}

    	}
	}

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
    	if(root == null)
    		return "null";

    	StringBuilder res = new StringBuilder();

    	LinkedList<TreeNode> queue = new LinkedList<>();
    	queue.add(root);

    	while(!queue.isEmpty()){
    		TreeNode node = queue.poll();
    		if(node != null){
    			res.append(node.val);
    			res.append(',');
    			queue.add(node.left);
    			queue.add(node.right);
    		}
    		else{
    			res.append("null,");
    		}
    	}

    	return res.toString();
    }

    //Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	if(data.equals("null")){
    		return null;
    	}
    	String[] nlist = data.split(",");

    	//build tree
    	LinkedList<TreeNode> queue = new LinkedList<>();

    	TreeNode root = new TreeNode(Integer.parseInt(nlist[0]));
    	queue.add(root);
		

    	for(int i = 1; i < nlist.length; i++){
    		TreeNode node = queue.poll();
    		if(!nlist[i].equals("null")){
    			node.left = new TreeNode(Integer.parseInt(nlist[i]));
    			queue.add(node.left);
    		}

    		if(!nlist[++i].equals("null")){
    			node.right = new TreeNode(Integer.parseInt(nlist[i]));
    			queue.add(node.right);
    		}
    	}
    	return root;
    }
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
}