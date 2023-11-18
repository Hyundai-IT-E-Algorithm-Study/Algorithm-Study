import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(sol());
		br.close();
	}
	
	public static int sol() {
		int[] dp = new int[N];
		dp[0] = 1;
		int max = 0;
		
		for(int i = 1; i < N; i++){
			max = 0;
			for(int j = 0; j < i; j++){
				if(A[j] > A[i]) max = Math.max(dp[j], max);
			}
			dp[i] = max + 1; // 누적에 1(현재 i) 더하기
		}
		
		for(int i = 0; i < N; i++) max = Math.max(dp[i], max);
	
		return max;
	}
}
