import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String[] picture = null;
    static int[][] normVisited = null;
    static int[][] weakVisited = null;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static char currColor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        picture = new String[N];

        for(int i=0; i<N; i++){
            picture[i] = br.readLine();
        }
        normVisited = new int[N][N];
        weakVisited = new int[N][N];

        int normCount = 0;
        int weakCount = 0;

        for (int y=0; y<N; y++){
            for (int x=0; x<N; x++){
                currColor = picture[y].charAt(x);
                if (normVisited[y][x] == 0){
                    normDFS(y,x);
                    normCount++;
                }
                if (weakVisited[y][x] == 0){
                    weakDFS(y,x);
                    weakCount++;
                }
            }
        }
        System.out.println(normCount+" "+weakCount);


    }

    static void normDFS(int y, int x){
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if (0<=ny && ny<N && 0<=nx && nx<N && normVisited[ny][nx]==0){
                if (picture[ny].charAt(nx)==currColor){
                    normVisited[ny][nx] = 1;
                    normDFS(ny,nx);
                }
            }
        }
    }
    static void weakDFS(int y, int x){
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if (0<=ny && ny<N && 0<=nx && nx<N && weakVisited[ny][nx]==0){
                if (currColor == 'B'){
                    if (picture[ny].charAt(nx)=='B'){
                        weakVisited[ny][nx] = 1;
                        weakDFS(ny,nx);
                    }
                }
                else {
                    if (picture[ny].charAt(nx)!='B'){
                        weakVisited[ny][nx] = 1;
                        weakDFS(ny,nx);
                    }
                }

            }
        }
    }
}
