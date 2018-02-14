import java.util.*;

public class GraphValidTree{
	public static void main(String[] args){
		int n = 5;
		int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
		boolean res = validTree_dfs(n, edges);
		System.out.println(res);
	}
	private static boolean validTree(int n, int[][] edges){
		if(n == 0)
			return true;
		return unionFind(n, edges);
	}

	private static boolean unionFind(int n, int[][] edges){
		int[] nodes = new int[n];

		for(int i = 0; i < n; i++)
			nodes[i] = i;

		for(int i = 0; i < edges.length; i++){
			int root = findRoot(nodes, edges[i][0]);
			int cur = findRoot(nodes, edges[i][1]);
			if(cur == root) // there is a cycle
				return false;

			//put the connected nodes in one set
			for(int j = 0; j < n; j++){
				if(nodes[j] == cur)
					nodes[j] = root;
			}
		}

		for(int i = 1; i < n; i++)
			if(nodes[i-1]!=nodes[i]) // there are more than one set, not a tree
				return false;

		return true;
	}

	private static int findRoot(int[] nodes, int i){
		while(nodes[i] != i)
			i = nodes[i];
		return i;
	}

	private static boolean validTree_dfs(int n, int[][] edges){
		//construct graph
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < n; i++)
			graph.add(new ArrayList<Integer>());

		for(int i = 0; i < edges.length; i++){
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}

		int[] visited = new int[n];

		//DFS
		for(int i = 0; i < n; i++){
			if(visited[i] != 2 && (i > 0 || !DFS(graph, i, visited, -1)))
				return false;
		}

		return true;

	}
	private static boolean DFS(ArrayList<ArrayList<Integer>> graph, int index, int[] visited, int parent){
		visited[index] = 1;
		ArrayList<Integer> neighbours = graph.get(index);

		for(int i = 0; i < neighbours.size(); i++){
			int nid = neighbours.get(i);
			if(visited[nid] == 1 && nid != parent) return false; // cycle

			if(visited[nid] == 0 && !DFS(graph, nid, visited, index))
				return false;
		}

		visited[index] = 2;
		return true;
	}

	private static boolean validTree_bfs(int n, int[][] edges){
		//construct graph
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < n; i++)
			graph.add(new ArrayList<Integer>());

		for(int i = 0; i < edges.length; i++){
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}

		int[] visited = new int[n];

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		visited[0] = 1;

		while(!queue.isEmpty()){
			int cur = queue.poll();
			ArrayList<Integer> neighbours = graph.get(cur);
			for(int i: neighbours){
				if(visited[i] == 1) return false;
				if(visited[i] == 0){
					queue.add(i);
					visited[i] = 1;
				}
			}
			visited[cur] = 2;
		}

		for(int v: visited)
			if(v == 0)
				return false;

		return true;
	}
}


