import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] graph;
    static boolean[][] visited;
    static boolean[][] visited_x;
    static int RG, xRG, notRG;
    static char color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];
        visited_x = new boolean[N][N];
        RG = xRG = notRG = 0;

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    color = graph[i][j];
                    dfs(i, j, false, visited);
                    if(color == 'R' || color == 'G') {
                        RG++;
                    } else {
                        notRG++;
                    }
                }
                if(!visited_x[i][j]) {
                    color = graph[i][j];
                    if(color == 'R' || color == 'G') {
                        dfs(i, j, true, visited_x);
                        xRG++;
                    }
                }
            }
        }

        System.out.println((RG + notRG) + " " + (xRG + notRG));
    }

    static void dfs(int y, int x, boolean flag, boolean[][] visited) {
        visited[y][x] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(!visited[ny][nx]) {
                    if(graph[ny][nx] == color && !flag) {
                        dfs(ny, nx, flag, visited);
                    } else if((graph[ny][nx] == 'R' || graph[ny][nx] == 'G') && flag) {
                        dfs(ny, nx, flag, visited);
                    }
                }
            }
        }
    }
}
