import java.util.*;
import java.io.*;
class Main {
	static int N;
	static int[] A;
	static int[] values;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	static void dfs(int depth) {
		if(depth==N) {
			int sum = 0;
			for(int i=0;i<N-1;i++) {
				sum += Math.abs(values[i]-values[i+1]);
			}
			
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				values[depth] = A[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = new int[N];
		values = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(max);
    }
}
