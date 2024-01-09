import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] tomatoBox;
    static int N, M;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoBox = new int[N][M];
        List<Point> tomatos = new ArrayList<>();
        cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoBox[i][j] == 1) {
                    tomatos.add(new Point(i, j));
                }
            }
        }

        bfs(tomatos);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoBox[i][j] == 0) {
                    cnt = -1;
                    break;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }

    public static void bfs(List<Point> tomatos) {
        Queue<Pair> queue = new LinkedList<>();
        for (Point tomato : tomatos) {
            queue.add(new Pair(tomato, cnt));
        }
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Point point = current.point;
            cnt = current.cnt;
            
            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];
                
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (tomatoBox[ny][nx] == 0) {
                        tomatoBox[ny][nx] = 1;
                        queue.add(new Pair(new Point(ny, nx), cnt + 1));
                    }
                }
            }
        }
    }

    static class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Pair {
        Point point;
        int cnt;

        Pair(Point point, int cnt) {
            this.point = point;
            this.cnt = cnt;
        }
    }
}
