import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

      //가로 세로 주의
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        isVisited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int wSum = 0;
        int bSum = 0;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'W' && !isVisited[i][j]) wSum += (int) Math.pow(dfs(0, i, j), 2);
                else if(map[i][j] == 'B' && !isVisited[i][j]) bSum += (int) Math.pow(dfs(0, i, j), 2);
            }
        }

        System.out.println(wSum + " " + bSum);
        br.close();
    }

    public static int dfs(int cnt, int x, int  y){
        isVisited[x][y] = true;
        cnt++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < M && 0 <= ny && ny < N && !isVisited[nx][ny] && map[nx][ny] == map[x][y]) {
                cnt = dfs(cnt, nx, ny);
            }
        }
        return cnt;
    }
}
