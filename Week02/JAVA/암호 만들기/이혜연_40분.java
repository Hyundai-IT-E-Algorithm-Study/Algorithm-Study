import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] arr;
	static char[] result;
	static boolean[] visited;
	static int cnt1 = 0; //모음 갯수
	static int cnt2 = 0; //자음 갯수
	static void dfs(int start, int depth) {
		if(depth == C) {
			for(char value : result) {
				if(value=='a'||value=='e'||value=='i'||value=='o'||value=='u')
					cnt1++;
				else
					cnt2++;
			}
			
			if(cnt1>=1 && cnt2>=2) {
				for(char value : result)
					System.out.print(value);
				System.out.println();
			}
			cnt1 = 0; 
			cnt2 = 0;
			return;
		}
		
		for(int i=start;i<L;i++) {
			if(!visited[depth]) {
				visited[depth] = true;
				result[depth] = arr[i];
				dfs(i+1, depth+1);
				visited[depth] = false;
			}
		}

	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		arr = new char[L];
		result = new char[C];
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<L;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		dfs(0, 0);
	}
}
