import java.util.*;

public class CourseSchedule{
	public static void main(String[] args){
		int numCourses = 2;
		int[][] prerequisites = {{1,0}};

		boolean res = canFinish(numCourses, prerequisites);
		System.out.println(res);
	
	}
	private static boolean canFinish(int numCourses, int[][] prerequisites){
		//building graph
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < numCourses; i++){
			graph.add(new ArrayList<Integer>());
		}

		for(int i = 0; i < prerequisites.length; i++){
			graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}


		//topological sort
		int[] visited = new int[numCourses];
		boolean res = true;
		for(int i = 0; i < numCourses; i++){
			if(visited[i] != 2 && !dfs(visited, graph, i))
				res = false;
		}

		return res;
		
	}

	private static boolean dfs(int[] visited, ArrayList<ArrayList<Integer>> graph, int c){
		if(visited[c] == 1)
			return false;

		visited[c] = 1;

		ArrayList<Integer> courses = graph.get(c);

		for(int i = 0; i < courses.size(); i++){
			int cid = courses.get(i);
			if(visited[cid]!=2 && !dfs(visited, graph, cid))
				return false;
		}

		visited[c] = 2;
		return true;
	}


}