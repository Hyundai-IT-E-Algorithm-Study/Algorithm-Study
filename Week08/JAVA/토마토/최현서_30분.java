import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int M,N;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());


        int[][] tomato = new int[N][M]; //토마토 배열
        int[][] ripeTime = new int[N][M]; //익는시간 배열

        //입력 및 초기화 및 총 토마토 개수 구하기
        Queue<Point> q = new LinkedList<>();
        int tomatoNum = 0;
        int ripeNum = 0; //익은 숫자
        for (int y=0; y<N; y++){
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<M; x++){
                tomato[y][x] = Integer.parseInt(st.nextToken());
                if (tomato[y][x] >= 0) { //만약 토마토가 존재하면,
                    tomatoNum++;
                    if (tomato[y][x] == 1){ //만약 토마토가 익었으면,
                        q.offer(new Point(x,y));
                        ripeNum++;
                    }
                }
            }
        }
        //처음부터 다 익어있으면 0 출력
        if (ripeNum == tomatoNum) System.out.println(0);
            
        //처음부터 다 안 익어있으면, 시간에 따라 인접한 것들 영향주는 BFS 시작
        else {
            int currTime =0;
            while(!q.isEmpty()){
                Point currP = q.poll();
                int currY = currP.y;
                int currX = currP.x;
                currTime = ripeTime[currY][currX];

                for (int i=0; i<4; i++){
                    int adjY = currY + dy[i];
                    int adjX = currX + dx[i];
                    if (inBox(adjY,adjX) && tomato[adjY][adjX]==0) { //인접한 위치에 토마토가 존재하고 안 익었으면,
                        q.offer(new Point(adjX, adjY));
                        ripeTime[adjY][adjX] = currTime+1;
                        tomato[adjY][adjX] = 1;
                        ripeNum++;
                    }
                }
            }
            //BFS다 수행하고, 만약 만약 모든 토마토가 익었으면 시간 출력, 다 안익었으면 -1출력
            if (ripeNum == tomatoNum) System.out.println(currTime);
            else System.out.println(-1);
        }
    }
    static boolean inBox(int y, int x) {
        return 0<=y && y<N && 0<=x && x<M;
    }
}
