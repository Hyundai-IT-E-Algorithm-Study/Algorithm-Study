import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] dp = new int[100001];
    private static int[] ways = new int[100001];
    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
            System.out.println(1);
        } else {
            int[] result = bfs();
            System.out.println(result[0]);
            System.out.println(result[1]);
        }
    }

    public static int[] bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        ways[N] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int[] nxArr = {x - 1, x + 1, 2 * x};
            for (int nx : nxArr) {
                if (nx >= 0 && nx < 100001) {
                    if (dp[nx] == 0) {
                        dp[nx] = dp[x] + 1;
                        ways[nx] = ways[x];
                        queue.offer(nx);
                    } else if (dp[nx] == dp[x] + 1) {
                        ways[nx] += ways[x];
                    }
                }
            }
        }
        return new int[]{dp[K], ways[K]};
    }
}
