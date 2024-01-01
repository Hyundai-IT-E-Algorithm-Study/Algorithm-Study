import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = { 0, 0, -1, 1}; // 상하좌우
    static int[] dy = { -1, 1, 0, 0}; // 상하좌우
    static boolean[][] isVisited;
    static boolean[][] isRGVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        isVisited = new boolean[N][N];
        isRGVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                map[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        int RGcnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                if(!isVisited[i][j]) {
                    bfs(map, i, j, N);
                    cnt++;
                }
                if(!isRGVisited[i][j]) {
                    bfsRG(map, i, j, N);
                    RGcnt++;
                }
            }
        }

        System.out.println(cnt + " " + RGcnt);

    }

    public static void bfs(char[][] map, int x, int y, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        isVisited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] location = queue.poll();
            int curX = location[0];
            int curY = location[1];

            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !isVisited[nextX][nextY] && map[curX][curY] == map[nextX][nextY]) {
                    queue.offer(new int[] {nextX, nextY});
                    isVisited[nextX][nextY] = true;
                }
            }
        }
    }

    public static void bfsRG(char[][] map, int x, int y, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        isRGVisited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] location = queue.poll();
            int curX = location[0];
            int curY = location[1];

            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !isRGVisited[nextX][nextY]) {
                    if(map[curX][curY] == 'R' || map[curX][curY] == 'G') {
                        if(map[nextX][nextY] == 'R' || map[nextX][nextY] == 'G') {
                            queue.offer(new int[] {nextX, nextY});
                            isRGVisited[nextX][nextY] = true;
                        }
                    } else {
                        if(map[curX][curY] == map[nextX][nextY]) {
                            queue.offer(new int[] {nextX, nextY});
                            isRGVisited[nextX][nextY] = true;
                        }
                    }
                }
            }
        }
    }

}
