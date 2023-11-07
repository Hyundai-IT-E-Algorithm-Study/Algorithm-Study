import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, V;
    static int[][] adjMatrix;
    static int[] nodes;
    static boolean[] isVisited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adjMatrix = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];
        nodes = new int[N];
        for(int i = 1; i <= N; i++){
            nodes[i-1] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1;
        }

        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb.toString());


        isVisited = new boolean[N + 1];
        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb.toString());

        br.close();
    }


    public static void dfs(int curr){
        sb.append(curr + " ");
        isVisited[curr] = true;
        for(int node : nodes) {
            if (!isVisited[node] && adjMatrix[curr][node] == 1){
                dfs(node);
            }
        }

    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isVisited[start] = true;
        while (!q.isEmpty()){
            int currNode = q.poll();
            sb.append(currNode + " ");
            for(int node : nodes){
                if (!isVisited[node] && adjMatrix[currNode][node] == 1){
                    isVisited[node] = true;
                    q.offer(node);
                }
            }
        }
    }

}
