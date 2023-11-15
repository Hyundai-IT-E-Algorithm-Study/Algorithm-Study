import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Point{
	private int y;
	private int x;
	public Point(int y,int x) {
		this.y=y;
		this.x=x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
}
public class Main {
    static char[][] graph;
    static int[] dx= {0,0,1,-1};
    static int[] dy= {1,-1,0,0};
    static int[][] distance;
    static int N,M;
    	
    public static int bfs(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y,x));
        distance[y][x]=1;
        while(!q.isEmpty()) {
            Point pos = q.poll();
            x=pos.getX();
            y=pos.getY();
            for(int i = 0; i < 4; i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0 && nx<M && ny>=0 && ny<N) {
                	if(graph[ny][nx]=='1' && distance[ny][nx]==-1) {
                		q.offer(new Point(ny,nx));
                		distance[ny][nx]=distance[y][x]+1;
                		if (ny==N-1 && nx==M-1) return distance[ny][nx];
                	}
                }
            }
        }
        return -1;
    }
	public static void main(String args[]) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		graph=new char[N][M];
		distance=new int[N][M];
		for(int j=0;j<N;j++) {
			Arrays.fill(distance[j],-1);
		}
		
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			graph[i]=str.toCharArray();
		}
		
		System.out.println(bfs(0,0));
	}

}
