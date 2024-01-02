import java.util.*;
import java.io.*;
class Main {
	static boolean[][] visited;
	static char[][] graph;
	static int N;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int cnt1 = 0;
	static int cnt2 = 0;
	
	static void dfs(char color, int x, int y) {
		if(x<1 || x>N || y<1 || y>N)
			return;
		for(int i=0;i<4;i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			if(newX>=1&&newX<=N && newY>=1&&newY<=N) {
				if(!visited[newX][newY] && graph[newX][newY]==color) {
					visited[newX][newY] = true;
					dfs(graph[newX][newY], newX, newY);
				}
			}
		}
	}
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new char[N+1][N+1];
		visited = new boolean[N+1][N+1];

		for(int i=1;i<=N;i++) {
			String arr = br.readLine();
			for(int j=1;j<=N;j++) {
				graph[i][j] = arr.charAt(j-1);
			}
		}
		
	
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(!visited[i][j]) {
					dfs(graph[i][j],i,j);
					cnt1++;
				}
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				visited[i][j] = false;
				if(graph[i][j] == 'R')
					graph[i][j] = 'G';
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(!visited[i][j]) {
					dfs(graph[i][j],i,j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1+" "+cnt2);
		
    }
}
