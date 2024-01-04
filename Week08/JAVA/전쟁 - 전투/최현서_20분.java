import java.util.Scanner;

public class Main {
    static int w,h, cnt;
    static String[] field;
    static boolean[][] visited;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static char team;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        h = sc.nextInt();

        field = new String[h];

        for(int i=0; i<h; i++){
            field[i] = sc.next();
        }

        visited = new boolean[h][w];

        int alias=0;
        int enemy=0;

        for (int y=0; y<h; y++){
            for (int x=0; x<w; x++){
                if (!visited[y][x]){
                    team = field[y].charAt(x);
                    cnt = 1;
                    visited[y][x] = true;
                    dfs(y,x);
                    if (team=='W') alias += (cnt*cnt);
                    else enemy += (cnt*cnt);
                }
            }
        }
        System.out.println(alias+" "+enemy);


    }
    static void dfs(int y, int x){
        for (int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (inField(ny,nx) && !visited[ny][nx] && field[ny].charAt(nx)==team){
                cnt++;
                visited[ny][nx] = true;
                dfs(ny,nx);
            }
        }
    }

    static boolean inField(int y, int x){
        return 0<=y && y<h && 0<=x && x<w;
    }
}
