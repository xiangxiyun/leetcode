import java.util.*;

public class CourseSchedule{
	public static void main(String[] args){
		int numCourses = 2;
		int[][] prerequisites = {{1,0}};

		boolean res = canFinish_bfs(numCourses, prerequisites);
		System.out.println(res);
	
	}
	private static boolean canFinish_dfs(int numCourses, int[][] prerequisites){
		//building graph
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < numCourses; i++){
			graph.add(new ArrayList<Integer>());
		}

		for(int i = 0; i < prerequisites.length; i++){
			graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}


		//topological sort
		boolean[] visited = new boolean[numCourses];
		boolean res = true;
		for(int i = 0; i < numCourses; i++){
			if(!dfs(visited, graph, i))
				res = false;
		}

		return res;
		
	}

	private static boolean dfs(boolean[] visited, ArrayList<ArrayList<Integer>> graph, int c){
		if(visited[c] == true)
			return false;

		visited[c] = true;

		ArrayList<Integer> courses = graph.get(c);

		for(int i = 0; i < courses.size(); i++){
			int cid = courses.get(i);
			if(!dfs(visited, graph, cid))
				return false;
		}

		visited[c] = false;
		return true;
	}

	private static boolean canFinish_bfs(int numCourses, int[][] prerequisites){
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < numCourses; i++){
			graph.add(new ArrayList<Integer>());
		}

		int[] degree = new int[numCourses];

		for(int i = 0; i < prerequisites.length; i++){
			degree[prerequisites[i][1]]++;
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int count = 0;

		for(int i = 0; i < degree.length; i++)
			if(degree[i] == 0){
				queue.add(i);
				count++;
			}


		while(!queue.isEmpty()){
			int node = queue.poll();
			ArrayList<Integer> nlist = graph.get(node);
			for(int i = 0; i < nlist.size(); i++){
				int nid = nlist.get(i);
				degree[nid]--;
				if(degree[nid] == 0){
					queue.add(nid);
					count++;
				}
			}
		}

		if(count != numCourses)
			return false;
		else
			return true;
	}

}