import java.util.ArrayList;
class Solution {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(graph, i, visited);
            answer++;
        }

        return answer;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int i, boolean[] visited) {
        visited[i] = true;
        for (int neighbor : graph.get(i)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}
