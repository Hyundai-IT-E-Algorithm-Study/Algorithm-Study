import java.util.*;
import java.io.*;
class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	static int result = 0;
	
	static int dfs1(int x, int y, int cnt) {
		if(x<0||x>=N || y<0||y>=M) {
			return cnt-1;
		}
		if(graph[x][y]==6) {
			return cnt-1;
		}
		
		return dfs1(x+1,y,cnt+1);	
	}
	static int dfs2(int x, int y, int cnt) {
		if(x<0||x>=N || y<0||y>=M) {
			return cnt-1;
		}
		if(graph[x][y]==6) {
			return cnt-1;
		}
		
		return dfs2(x-1,y,cnt+1);	
	}
	static int dfs3(int x, int y, int cnt) {
		if(x<0||x>=N || y<0||y>=M) {
			return cnt-1;
		}
		if(graph[x][y]==6) {
			return cnt-1;
		}
		
		return dfs3(x,y+1,cnt+1);	
	}
	static int dfs4(int x, int y, int cnt) {
		if(x<0||x>=N || y<0||y>=M) {
			return cnt-1;
		}
		if(graph[x][y]==6) {
			return cnt-1;
		}
		
		return dfs4(x,y-1,cnt+1);	
	}
	
	static int one(int x, int y) {
		return Math.max(Math.max(dfs3(x,y,0), dfs4(x,y,0)), 
				Math.max(dfs1(x,y,0), dfs2(x,y,0)))+1;	
	}
	
	static int two(int x, int y) {
		return Math.max(dfs3(x,y,0)+dfs4(x,y,0)+1, 
				dfs1(x,y,0)+dfs2(x,y,0)+1);	
	}
	
	static int three(int x, int y) {
		int num1 = dfs1(x,y,0)+dfs3(x,y,0)+1;
		int num2 = dfs1(x,y,0)+dfs4(x,y,0)+1;
		int num3 = dfs2(x,y,0)+dfs3(x,y,0)+1;
		int num4 = dfs2(x,y,0)+dfs4(x,y,0)+1;
		return Math.max(Math.max(num1,num2), 
					    Math.max(num3, num4));	
	}
	
	static int four(int x, int y) {
		int num1 = dfs1(x,y,0)+dfs3(x,y,0)+dfs4(x,y,0)+1;
		int num2 = dfs2(x,y,0)+dfs3(x,y,0)+dfs4(x,y,0)+1;
		int num3 = dfs1(x,y,0)+dfs2(x,y,0)+dfs3(x,y,0)+1;
		int num4 = dfs1(x,y,0)+dfs2(x,y,0)+dfs4(x,y,0)+1;
		return Math.max(Math.max(num1,num2), 
			    Math.max(num3, num4));	
	}
	
	static int five(int x, int y) {
		return dfs1(x,y,0)+dfs2(x,y,0)+dfs3(x,y,0)+dfs4(x,y,0)+1;
	}
	
	static int result() {
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(graph[i][j]==1) {
					sum+=one(i,j);
				}
				else if(graph[i][j]==2) {
					sum+=two(i,j);
				}
				else if(graph[i][j]==3) {
					sum+=three(i,j);
				}
				else if(graph[i][j]==4) {
					sum+=four(i,j);
				}
				else if(graph[i][j]==5) {
					sum+=five(i,j);
				}
				System.out.println(i+" "+j);
				System.out.println(sum);
			}
		}
		return sum;
	}
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(result());
    }
}



