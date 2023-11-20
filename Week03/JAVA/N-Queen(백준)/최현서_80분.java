//백준에서는 프로그래머스에서 했던 stack 여러개 방법이 시간초과가 떠서 
//시행착오 끝에 이 방법으로 맞췄습니다.
import java.util.Scanner;

public class Main {
	static int n;
	static int answer;
	
	static int[] queens = null;
	static int queenY;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		answer = 0;
		queens = new int[n+1]; //index를 x좌표, 값을 y좌표로 하는 배열 초기화(1~n까지)
		
		makeQueens(1);
		System.out.println(answer);

	}
	
	//x값이 같으면 x축방향 공격이 되므로, x=1부터 n까지 깊이탐색(재귀) 수행->"x축공격 가지치기"
	static void makeQueens(int x) {
		if (x > n) { //가지치기 안당하고 n까지 도달해야 n개의 퀸을 다 채운 것
			answer++;
			return;
    }
		for (int y = 1; y <= n; y++) {
			if (isPossible(x,y)) {//"나머지 공격 가지치기" 수행함수(맨밑에 있음)
				queens[x] = y; // 해당 위치에 queen 놔둠
				makeQueens(x + 1);
			}
		}
	}
	
	
	
	static boolean isPossible(int x, int y) {
		for (int i=1; i<x;i++) {//i는 x값과 같다.(x 이전값까지 할당됐으므로 수행)
			queenY = queens[i]; //y값 할당 
			if (y==queenY) return false; //y값이 같으면 y축 방향으로 공격 받음
			else if (x+y == i+queenY) return false; // x+y가 같으면 5시 대각선 방향으로 공격 받음
			else if (x-y == i-queenY) return false; // x-y가 같으면 7시 대각선 방향으로 공격 받음
		}
		return true; //3가지 경우 아니면 퀸을 놓아도 되는 위치임
	}
}
