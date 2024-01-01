import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    static int time = 0;
    static int[] map = new int[100001];
    static int[] dx = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // (0 ≤ N ≤ 100,000)
        int K = Integer.parseInt(st.nextToken()); // (0 ≤ K ≤ 100,000)
        
        findSol(N, K);

        System.out.println(time + "\n" + cnt);
    }

    public static void findSol(int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        map[N] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == K) {
                time = map[x] - 1;
                cnt++;
            }

            for (int i = 0; i < 3; i++) {
                int nextN = 0;
                if (i == 2) nextN = x * dx[i]; // 순간이동
                else nextN = x + dx[i];

                // 범위 내에 있고, (방문하지 않았거나, 방문했지만 최소값이라면)
                if(0 <= nextN && nextN <= 100000 && (map[nextN] == 0 || map[nextN] >= map[x] + 1)) {
                    map[nextN] = map[x] + 1;
                    q.add(nextN);
                }
            }
        }
    }
}
