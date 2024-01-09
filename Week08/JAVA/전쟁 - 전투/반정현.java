import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static char[][] war;
    static int N, M;
    static boolean[][] visitedW;
    static boolean[][] visitedB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        war = new char[M][N];
        visitedW = new boolean[M][N];
        visitedB = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                war[i][j] = line.charAt(j);
            }
        }

        int wcnt = 0, bcnt = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (war[i][j] == 'W' && !visitedW[i][j]) {
                    int count = dfs(i, j, 'W', visitedW);
                    wcnt += count * count;
                } else if (war[i][j] == 'B' && !visitedB[i][j]) {
                    int count = dfs(i, j, 'B', visitedB);
                    bcnt += count * count;
                }
            }
        }

        System.out.println(wcnt + " " + bcnt);

        br.close();
    }

    public static int dfs(int y, int x, char team, boolean[][] visited) {
        if (y < 0 || x < 0 || y >= M || x >= N || visited[y][x] || war[y][x] != team) {
            return 0;
        }

        visited[y][x] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            count += dfs(y + dy[i], x + dx[i], team, visited);
        }

        return count;
    }
}
