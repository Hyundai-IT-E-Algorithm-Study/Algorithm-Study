//1번
import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static boolean[][] isVisited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int R;
	static int C;
	static int sheep, wolf = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		isVisited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int liveSheep = 0;
		int liveWolves = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!isVisited[i][j] && map[i][j] != '#') {
					sheep = 0;
					wolf = 0;
					dfs(i, j);
					if (sheep > wolf) liveSheep += sheep;
					else liveWolves += wolf;
				}
			}
		}
		System.out.println(liveSheep + " " + liveWolves);
	}

	private static void dfs(int x, int y) {
    	if ('k' == map[x][y]) sheep++;
    	else if ('v' == map[x][y]) wolf++;

    	isVisited[x][y] = true;

    	for (int i = 0; i < 4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if (0 <= nx && nx < R  && 0 <= ny && ny < C && !isVisited[nx][ny] && map[nx][ny] != '#') {
    			dfs(nx, ny);
    		}
    	}
    }
}


//2번
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < R; i++) {
			int type = Integer.parseInt(st.nextToken());
			if(type == 1) sol1();
			else if(type == 2) sol2();
			else if(type == 3) sol3();
			else if(type == 4) sol4();
			else if(type == 5) sol5();
			else if(type == 6) sol6();
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void sol1() {
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N / 2; i++) {
				int temp = map[i][j];
				map[i][j] = map[N - 1 - i][j];
				map[N - 1 - i][j] = temp;
			}
		}
	}
	
	public static void sol2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp = map[i][j];
				map[i][j] = map[i][M - 1 - j];
				map[i][M - 1 - j] = temp;
			}
		}
	}
	
	public static void sol3() {
		int[][] newMap = new int[M][N];
		int x = 0;
		int y = N - 1;
		
		for (int i = 0; i < N; i++) {
			x = 0;
			for (int j = 0; j < M; j++) {
				newMap[x][y] = map[i][j];
				x++;
			}
			y--;
		}
		
		int temp = N;
		N = M;
		M = temp;
		map = newMap;
	}
	
	public static void sol4() {
		int[][] newMap = new int[M][N];
		int x = M - 1;
		int y = 0;
		
		for (int i = 0; i < N; i++) {
			x = M - 1;
			for (int j = 0; j < M; j++) {
				newMap[x][y] = map[i][j];
				x--;
			}
			y++;
		}
		
		int temp = N;
		N = M;
		M = temp;
		
		map = newMap;
	}
	
	public static void sol5() {
		int x1 = 0, y1 = 0;
		int x2 = 0, y2 = M / 2;
		int x3 = N / 2, y3 = M / 2;
		int x4 = N / 2, y4 = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp = map[x1][y1];
				map[x1][y1] = map[x4][y4];
				map[x4][y4] = map[x3][y3];
				map[x3][y3] = map[x2][y2];
				map[x2][y2] = temp;
				
				y1++;
				y2++;
				y3++;
				y4++;
			}
			y1 = 0;
			y2 = M / 2;
			y3 = M / 2;
			y4 = 0;
			x1++;
			x2++;
			x3++;
			x4++;
		}
		
	}
	
	public static void sol6() {
		int x1 = 0, y1 = 0;
		int x2 = 0, y2 = M / 2;
		int x3 = N / 2, y3 = M / 2;
		int x4 = N / 2, y4 = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp = map[x1][y1];
				map[x1][y1] = map[x2][y2];
				map[x2][y2] = map[x3][y3];
				map[x3][y3] = map[x4][y4];
				map[x4][y4] = temp;
				
				y1++;
				y2++;
				y3++;
				y4++;
			}
			y1 = 0;
			y2 = M / 2;
			y3 = M / 2;
			y4 = 0;
			x1++;
			x2++;
			x3++;
			x4++;
		}
	}
}
