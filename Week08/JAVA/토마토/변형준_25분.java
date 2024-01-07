import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            int[] currPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = currPoint[0] + dx[i];
                int y = currPoint[1] + dy[i];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                // 익지 않은 토마토가 있을 때
                if (map[x][y] == 0) {
                    map[x][y] = map[currPoint[0]][currPoint[1]] + 1;
                    queue.add(new int[] {x, y});
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) return -1;
                if (answer < map[i][j]) answer = map[i][j];
            }
        }

        return answer - 1; // 익은 토마토 1부터 시작했으므로 1을 빼준다.
    }
}
