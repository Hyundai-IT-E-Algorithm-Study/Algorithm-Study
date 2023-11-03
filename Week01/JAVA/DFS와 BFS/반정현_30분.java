import java.util.*;
import java.io.*;

public class Main {
	public static boolean visited[];
	public static boolean visited_bfs[];
	public static ArrayList<PriorityQueue<Integer>> graph = new ArrayList<PriorityQueue<Integer>>();
	public static ArrayList<PriorityQueue<Integer>> graph_bfs = new ArrayList<PriorityQueue<Integer>>();

	public static void dfs(int x) {
		visited[x]=true;
		System.out.print((x+1)+" ");
		while(!graph.get(x).isEmpty()) {
			int y=graph.get(x).poll();
			if(!visited[y]) dfs(y);
		}	
	}
	
	public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited_bfs[start] = true;

        while(!q.isEmpty()) {    
            int x = q.poll();
            System.out.print((x+1) + " ");
            while(!graph_bfs.get(x).isEmpty()) {
                int y = graph_bfs.get(x).poll();
                if(!visited_bfs[y]) {
                    q.offer(y);
                    visited_bfs[y] = true;
                }
            }
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int v=Integer.parseInt(st.nextToken());
		
		visited=new boolean[n];
		visited_bfs=new boolean[n];
		for(int j=0;j<n;j++) {
			graph.add(new PriorityQueue<Integer>());
			graph_bfs.add(new PriorityQueue<Integer>());
		}
		
		for(int i=0;i<m;i++) {
			StringTokenizer strk=new StringTokenizer(br.readLine()," ");
			int first=Integer.parseInt(strk.nextToken());
			int second=Integer.parseInt(strk.nextToken());
			graph.get(first-1).add(second-1);
			graph.get(second-1).add(first-1);
			graph_bfs.get(first-1).add(second-1);
			graph_bfs.get(second-1).add(first-1);
		}
		
		dfs(v-1);
		System.out.println();
		bfs(v-1);
		
	}

}
