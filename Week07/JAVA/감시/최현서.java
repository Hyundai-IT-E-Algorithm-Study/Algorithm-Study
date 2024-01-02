import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int minBlindCnt;
    static int[][] office;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        office = new int[N][M];

        for (int y=0; y<N; y++){
            for (int x=0; x<M; x++){
                office[y][x] = sc.nextInt();
            }
        }

        minBlindCnt = N*M;
        dfs(0);
        System.out.println(minBlindCnt);

    }

    static void dfs(int start){
        for(int s=start; s<N*M; s++){
            int y = s/M;
            int x = s%M;
            if (office[y][x]==0 || office[y][x]==6 || office[y][x]==9) continue;
            int nextStart = s+1;
            //현재의 값을 구별하기 위해서 임의로 10 더해줘서 넣음(나중에 지우기 위해서)
            int v = s+10;

            if (office[y][x]==1){
                cctvAction(y,x,0,0,v);
                dfs(nextStart);
                cctvAction(y,x,0,v,0);

                cctvAction(y,x,1,0,v);
                dfs(nextStart);
                cctvAction(y,x,1,v,0);

                cctvAction(y,x,2,0,v);
                dfs(nextStart);
                cctvAction(y,x,2,v,0);

                cctvAction(y,x,3,0,v);
                dfs(nextStart);
                cctvAction(y,x,3,v,0);
                break;
            }
            else if (office[y][x]==2){
                cctvAction(y,x,0, 0,v);
                cctvAction(y,x,1, 0,v);
                dfs(nextStart);
                cctvAction(y,x,0, v,0);
                cctvAction(y,x,1, v,0);

                cctvAction(y,x,2, 0,v);
                cctvAction(y,x,3, 0,v);
                dfs(nextStart);
                cctvAction(y,x,2, v,0);
                cctvAction(y,x,3, v,0);
                break;
            }
            else if (office[y][x]==3){
                cctvAction(y,x,0, 0,v);
                cctvAction(y,x,2, 0,v);
                dfs(nextStart);
                cctvAction(y,x,0, v,0);
                cctvAction(y,x,2, v,0);

                cctvAction(y,x,0, 0,v);
                cctvAction(y,x,3, 0,v);
                dfs(nextStart);
                cctvAction(y,x,0, v,0);
                cctvAction(y,x,3, v,0);

                cctvAction(y,x,1, 0,v);
                cctvAction(y,x,2, 0,v);
                dfs(nextStart);
                cctvAction(y,x,1, v,0);
                cctvAction(y,x,2, v,0);

                cctvAction(y,x,1, 0,v);
                cctvAction(y,x,3, 0,v);
                dfs(nextStart);
                cctvAction(y,x,1, v,0);
                cctvAction(y,x,3, v,0);
                break;
            }
            else if (office[y][x]==4){
                //0,1,2
                cctvAction(y,x,0, 0,v);
                cctvAction(y,x,1, 0,v);
                cctvAction(y,x,2, 0,v);
                dfs(nextStart);
                cctvAction(y,x,0, v,0);
                cctvAction(y,x,1, v,0);
                cctvAction(y,x,2, v,0);
                //0,1,3
                cctvAction(y,x,0, 0,v);
                cctvAction(y,x,1, 0,v);
                cctvAction(y,x,3, 0,v);
                dfs(nextStart);
                cctvAction(y,x,0, v,0);
                cctvAction(y,x,1, v,0);
                cctvAction(y,x,3, v,0);
                //0,2,3
                cctvAction(y,x,0, 0,v);
                cctvAction(y,x,2, 0,v);
                cctvAction(y,x,3, 0,v);
                dfs(nextStart);
                cctvAction(y,x,0, v,0);
                cctvAction(y,x,2, v,0);
                cctvAction(y,x,3, v,0);
                //1,2,3
                cctvAction(y,x,1, 0,v);
                cctvAction(y,x,2, 0,v);
                cctvAction(y,x,3, 0,v);
                dfs(nextStart);
                cctvAction(y,x,1, v,0);
                cctvAction(y,x,2, v,0);
                cctvAction(y,x,3, v,0);
                break;
            }
            else if (office[y][x]==5){
                for(int i=0; i<4; i++){
                    cctvAction(y,x,i,0,v);
                }
            }
        }

        int blindCnt = 0;
        for (int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                if(office[y][x]==0) blindCnt++;
            }
        }
        if (minBlindCnt>blindCnt) minBlindCnt=blindCnt;
    }

    static void cctvAction(int y, int x, int n, int t, int v){
        if (n==0){
            for (int k=y-1; k>=0; k--){
                if (office[k][x]==6) break;
                if (office[k][x]==t) office[k][x]=v;
            }
        }
        if (n==1){
            for (int k=y+1; k<N; k++){
                if (office[k][x]==6) break;
                if (office[k][x]==t) office[k][x]=v;
            }
        }
        if (n==2){
            for (int k=x-1; k>=0; k--){
                if (office[y][k]==6) break;
                if (office[y][k]==t) office[y][k]=v;
            }
        }
        if (n==3){
            for (int k=x+1; k<M; k++){
                if (office[y][k]==6) break;
                if (office[y][k]==t) office[y][k]=v;
            }
        }
    }
}
