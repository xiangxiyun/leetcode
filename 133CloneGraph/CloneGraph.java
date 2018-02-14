import java.util.*;

public class CloneGraph{
	public static void main(String[] args){

	}
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> DFSmap = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	UndirectedGraphNode graph = dfs(node);

    }

    private static UndirectedGraphNode dfs(UndirectedGraphNode node){
    	if(DFSmap.containsKey(node)){
    		return DFSmap.get(node);
    	}
    	else{
	    	UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
	    	DFSmap.put(node, newnode);
	    	for(UndirectedGraphNode n : node.neighbors){
	    		newnode.neighbors.add(dfs(n););
	    	}
	    	return newnode;
	    }
    }
}

//Definition for undirected graph.
class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};