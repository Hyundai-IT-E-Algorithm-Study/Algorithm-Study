// 백트래킹을 사용해서 풀려고 했으나, 시간초과가 계속 뜸
// 결국 DP를 쓰지 않으면 풀기 어렵다는 것을 깨닫고,
// DP문제를 처음 풀어봐서 인터넷을 참고하고 이해 후 구현했습니다.

//백트래킹을 하면 수열의 길이만큼의 깊이로 들어가야하는데
//DP를 활용하면 이중 for문으로 해결 가능


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = null;
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int seqLen = Integer.parseInt(st.nextToken());
		
		int[] seq = new int[seqLen];
		int[] DP = new int[seqLen];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i < seqLen; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		//answer의 최솟값은 1이기에 1로 초기화
		int answer = 1;
		
		//currIdx까지 감소하는 수열 길이의 최대값을 구하고 DP에 넣는 for문
		//구하는 원리 : 전의 수열값이 현재 수열값보다 크면 전 수열최대길이에 1 추가 가능
		//전까지의 최대값을 DP에 저장해놨기에, 
		//그 중 "현재값보다 큰 수열값의 DP값에 1을 더한 것들중 최대값"이 현재의 최대값
		//currIdx가 0이면 무조건 1이기 때문에, 이걸 이용해서 끝까지 다 최대값 구할 수 있음
		
		//DP활용가능여부 : 쪼개서 초기값을 구할 수 있고, 초기값으로 연쇄적으로 n번째값을 구할 수 있을때!! 
		for(int currIdx=0; currIdx < seqLen; currIdx++) {
			//현재 위치의 수열길이는 무조건 1보다 크거나 같기에 1로 초기화
			DP[currIdx]=1;
			//앞의 값 전부 확인
			for(int pastIdx=0; pastIdx < currIdx; pastIdx++) {
				//앞의 값이 더 커야 길이 추가 가능
				if (seq[pastIdx] > seq[currIdx]) {
					//더해준값이 앞에 더해준값보다 클때 DP값 갱신 가능
					if (DP[currIdx]< (DP[pastIdx]+1)) DP[currIdx] = DP[pastIdx]+1; 
				}
				//만약 더 큰게 하나도 없으면, 어차피 DP최대값만 구하기에 DP값 넣을 필요 없음
			}
			//만약 기존의 answer보다 현재의 최대 길이가 더크면 answer 최대값 갱신
			if (answer < DP[currIdx]) answer = DP[currIdx];
		}
		
		System.out.println(answer);
		
		br.close();
	}
}
