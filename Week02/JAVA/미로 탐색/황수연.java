import java.util.*;
import java.io.*;

public class Main {
    static int[][] adj; // 미로 구조
    static boolean[][] visited; // 방문 여부
    static int N;
    static int M;
    static int[] dy = {0,-1,0,1};
    static int[] dx = {1,0,-1,0};
    
	public static void main(String[] args) throws IOException {
       	Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        // 초기화
        adj = new int[N][M];
        visited = new boolean[N][M];
        
        // 미로 구조 저장
        for(int i=0; i<N; i++) {
            String maze = sc.next();
            for(int j = 0; j < M; j++){
                adj[i][j] = maze.charAt(j)-'0'; // => 아스키 부호 변환 
            }
        }
        
        // 함수 호출
        bfs();
	}
    
    public static void bfs() {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(0); // x 시작점
        qy.offer(0); // y 시작점
        visited[0][0] = true;
        
        while(!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();
            
            // 상하좌우 확인
            for(int i=0; i<4; i++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                // 미로 범위 확인
                if(xx >= 0 && yy >= 0 && xx < N && yy < M){
                    qx.offer(xx);
                    qy.offer(yy); // 큐에 이동한 좌표 추가
                    visited[xx][yy] = true;
                    
                    adj[xx][yy] = adj[x][y] + 1; // 한칸 이동 횟수
                }
            }
        }
        
    }
}
