import java.util.*;

//DFS가 근소하게 좀 더 빠름
class Solution {
    
    static boolean[] isVisited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                dfs(computers, i);
 //               bfs(q, computers, i);
                answer++;
            }
        }
        return answer;
    }
    
    static void dfs(int[][] computers, int start) {
        isVisited[start] = true;
        for(int next = 0; next < computers.length; next++) {
            if(computers[start][next] == 1 && !isVisited[next] && start != next) {
                dfs(computers, next);
            }
        }
    }
    
    static void bfs(Queue<Integer> q, int computers[][], int depth) {
        q.offer(depth);
        isVisited[depth] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int j = 0; j < computers.length; j++) {
                if(computers[curr][j] == 1 && !isVisited[j] && curr != j) {
                    isVisited[j] = true;
                    q.offer(j);
                }
            }
        }
    }
}
