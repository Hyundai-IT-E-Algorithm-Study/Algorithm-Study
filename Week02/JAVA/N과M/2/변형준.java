import java.util.Scanner;

public class Main {

	static int N, M, totalCnt;
	static int[] numbers, arr; // 선택한 숫자, 사용자 입력 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		comb(0, 0);

	}
	
	//cnt : cnt번째 카드 뽑기
	//startIndex : arr에서 startIndex부터 카드 뽑기 -> 따라서 isSelected로 중복 확인 안해도됨.
	private static void comb(int cnt, int startIndex) {
		if(cnt == M) {
			totalCnt++;
			for (int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = startIndex; i < N; i++) {
			numbers[cnt] = arr[i]; //cnt번째 숫자를 배열의 i번째 숫자로 지정
			comb(cnt+1, i+1);
		}
	}
	

}
