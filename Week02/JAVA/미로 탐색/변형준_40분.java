import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1,+1, 0, 0};
    static int[] dy = { 0, 0,-1,+1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        bfs(0,0);
        System.out.println(map[N - 1][M - 1]);
    }
    public static void bfs(int n, int m){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(n, m));
        Point currP = new Point(n, m);
        Point nextP;
        isVisited[n][m] = true;
        while(!q.isEmpty()){
            currP = q.poll();
            for(int i = 0; i < 4; i++){
                int x = currP.x + dx[i];
                int y = currP.y + dy[i];
                nextP = new Point(x, y);
                if(0 <= nextP.x && nextP.x < N && 0 <= nextP.y && nextP.y < M && map[x][y] == 1 && !isVisited[x][y]){
                    q.offer(nextP);
                    isVisited[x][y] = true;
                    map[x][y] = map[currP.x][currP.y] + 1;
                }
            }
        }

    }
}
