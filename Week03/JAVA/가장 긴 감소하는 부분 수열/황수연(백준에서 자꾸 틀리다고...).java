import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
       	Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] dp = new int[N];
        
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt(); // A 수열 입력받기
            dp[i] = 1; // dp 수열 초기화
            for(int k=0; k<i; k++){
                if(A[i] > A[k]){ 
                    dp[i] = dp[i] + 1;
                }
            }
        }
        int max = 0; // 현재 인덱스까지의 최대 증가 부분 수열의 길이를 저장
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]); // 가장 긴 증가하는 부분 수열의 최대 길이 찾기
        }
        System.out.println(max);
	}
}
