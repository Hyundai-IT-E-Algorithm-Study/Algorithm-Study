class Solution {
	static int n;
	static int[][] computers;
	static boolean[] visited;
    public int solution(int n, int[][] computers) {
    	Solution.n = n;
    	Solution.computers = computers;
    	int answer = 0;
    	visited = new boolean[n];

      //방문하지 않은 컴퓨터에 대해서 dfs수행-> 
      //dfs수행개수 == 네트워크수 (bfs도 가능)
      //dfs나 bfs가 수행이 됐다는 것 == 서로 연결돼있다
    	for (int computer=0; computer<n; computer++) {
    		if (visited[computer]) continue;
    		answer++;
    		visited[computer] = true;
    		dfs(computer);
    	}
        return answer;
    }
    public static void dfs(int computer) {
    	for (int c=0; c<n; c++) {
    		if (computer!=c && !visited[c] && computers[computer][c]==1) {
    			visited[c] = true;
    			dfs(c);
    		}
    	}
    }
}
