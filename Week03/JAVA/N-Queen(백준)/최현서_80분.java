//백준에서는 프로그래머스에서 했던 stack 여러개 방법이 시간초과가 떠서 
//시행착오 끝에 이 방법으로 풀었습니다.
import java.util.Scanner;

public class Main {
	static int n;
	static int answer;

	static int[] queens = null;
	static int queenY;
	static boolean isPossible;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		answer = 0;
		queens = new int[n + 1]; // index를 x좌표, 값을 y좌표로 하는 배열 생성(1~n)

		makeQueens(1);
		System.out.println(answer);

	}

	// x값이 같으면 x축방향 공격이 되므로, x=1부터 n까지 깊이 탐색(재귀) 수행->"x축방향 공격 가지치기"
	static void makeQueens(int x) {
		if (x > n) { // 가지치기 안당하고 n번째 재귀함수까지 도달해야 n개의 퀸을 다 채운 것
			answer++;
			return;
		}
		
		for (int y = 1; y <= n; y++) {
			
			isPossible = true;
			//가지치기 for문
			for (int queenX = 1; queenX < x; queenX++) {//이전에 놓아진 x-1개의 퀸들을 배열에서 하나씩 빼서 공격가능여부 확인
				queenY = queens[queenX]; // y값 할당
				if (y == queenY) {
					isPossible=false;
					break;} // y값이 같으면 y축 방향으로 공격 받음
				else if (x + y == queenX + queenY) {
					isPossible=false;
					break;} // x+y가 같으면 5시 대각선 방향으로 공격 받음
				else if (x - y == queenX - queenY) {
					isPossible=false;
					break;} // x-y가 같으면 7시 대각선 방향으로 공격 받음
			}
			
			
			// 가지치기 당하지 않은 x,y 배열에 넣고, 다음 재귀 수행
			if(isPossible) {
            		queens[x] = y;
			makeQueens(x + 1);
            		}

		}
	}
}
