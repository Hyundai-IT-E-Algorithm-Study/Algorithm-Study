class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        // 방문 체크 초기화
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }
        
        // dfs 함수 호출
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) { // 최종 남은 false인 개수 세기 = answer 개수
                dfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int i, int[][] computers, boolean[] visited) {
        visited[i] = true;
        
        for(int j = 0; j < computers.length; j++) { 
            if(i != j && computers[i][j] == 1 && visited[j] == false) {
                dfs(j, computers, visited); // j는 다음 노드
            }
        }
    }
}
