import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    static int N, answer;
    static int[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        visited = new boolean[N];
        answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dfs(new LinkedList<Integer>());
        System.out.println(answer);
    }

    static void dfs(LinkedList<Integer> res) {
        if(res.size() == N) {
            int diff = 0;
            for(int j=1; j<N; j++) {
                diff += Math.abs(res.get(j-1) - res.get(j));
            }
            answer = Math.max(answer, diff);
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                res.add(A[i]);
                dfs(res);
                res.removeLast();
                visited[i] = false;
            }
        }
    }
}
