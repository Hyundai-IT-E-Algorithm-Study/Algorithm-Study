import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = null;
	static StringTokenizer st = null;
	
	static int N,M;
	
	static int[][] miro = null; 
	static int[][] isVisited = null;
	
	//adjacent 역할(움직일 수 있는 범위)
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	static String[] currNode = null;
	
	
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//미로의 세로(N),가로(M) 길이 받음
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		//미로 완성
		miro = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			String row  = st.nextToken();
			for(int j=1; j<=M; j++) {
				miro[i][j]=row.charAt(j-1)-'0';
			}
		}
		

		
		
		//최단거리 -> BFS
		//미로에서 [1,1]을 root로 하는 BFS 수행
		isVisited = new int[N+1][M+1];
		BFS(1,1);
		System.out.println(isVisited[N][M]);
		
		
	}
	
	
	
	public static void BFS(int y, int x) {
		//큐 생성
		Queue<String> q = new LinkedList<>();
		//시작 넣음
		q.offer(y+","+x);
		isVisited[y][x] = 1;
		
		while(!q.isEmpty()) {
			//큐 빼면서 출력
			currNode = q.poll().split(",");
			
			int currY = Integer.parseInt(currNode[0]);
			int currX = Integer.parseInt(currNode[1]);
			//인접한것 큐에 넣음
			for (int i=0; i<4; i++) {
				int adjY = currY + dy[i];
				int adjX = currX + dx[i];
				
				if(adjY<=0 || adjY>N || adjX<=0 || adjX>M) continue;
				if(miro[adjY][adjX] == 1 && isVisited[adjY][adjX] == 0) {
				q.offer(adjY+","+adjX);
				isVisited[adjY][adjX] = isVisited[currY][currX]+1;
				}
			}
		}
	}
}
