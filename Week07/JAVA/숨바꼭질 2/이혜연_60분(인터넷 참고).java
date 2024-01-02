import java.util.*;
import java.io.*;
class Main {
	static int cnt = 0;
	static int[] time;
	static int min = Integer.MAX_VALUE;

	static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		time[n] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(min<time[now]) {
				return;
			}
			for(int i=0;i<3;i++) {
				int next;
				if(i==0) {
					next = now-1;
				}
				else if(i==1) {
					next = now+1;
				}
				else {
					next = now*2;
				}
				
				if(next == k) {
					cnt++;
					min=time[now];
				}
				
				if(next>=0 && next<=100000) {
					if(time[next]==0 || time[next]==time[now]+1) {
						q.add(next);
						time[next] = time[now]+1;
					}
				}
				
			}
		}
		
	}
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		time = new int[100001];
		if(N >= K) {
			System.out.println(N-K);
			System.out.println(1);
			return;
		}
		bfs(N,K);
		System.out.println(min+"\n"+cnt);
	
    }
}
