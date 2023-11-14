import java.util.Scanner;

public class Main {

	static int N, R, totalCnt;
	static int[] numbers; //  선택한 숫자 담는 배열
	static boolean[] isSelected; //카드 선택 여부 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 4
		R = sc.nextInt(); // 3
		numbers = new int[R];
		isSelected = new boolean[N+1]; //[~, false, false, false, false]
		
		perm(0);

	}
	
	
	private static void perm(int cnt) {  // cnt : 현재 뽑아야 하는 카드 위치
		//순열 함수
		if(cnt == R) { // 기저 조건 - 끝나는 조건
			totalCnt++;
			for (int cards : numbers) {
				System.out.print(cards+" ");
			}
			System.out.println(); // 선택한 카드
			return;
		}
		
		for (int card = 1; card <= N; card++) {
			if(isSelected[card]) continue;
			numbers[cnt] = card;  // cnt번 째 카드는 card 숫자 선택
			isSelected[card] = true;
			perm(cnt+1);
			isSelected[card] = false;
		}
	}
}
