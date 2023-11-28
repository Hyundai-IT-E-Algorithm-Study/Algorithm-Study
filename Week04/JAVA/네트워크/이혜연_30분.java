class Solution {
    static boolean[][] visited;
	static boolean[] visited2;
    static void dfs(int depth, int n, int[][] node) {	
        if(depth == n) return;
		for(int i=0;i<n;i++) {
			visited2[depth] = true;
			if(node[depth][i]==1 && !visited[depth][i]) {
                visited2[i] = true;
				visited[depth][i] = true;
				visited[i][depth] = true;	
				dfs(i,n,node);
			}
		}
	}
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n][n];
		visited2= new boolean[n];
        int answer = 0;
        for(int i=0;i<n;i++){
			if(!visited2[i]){	
				dfs(i,n,computers);
				answer++;
			}
		}
        return answer;
    }
}
