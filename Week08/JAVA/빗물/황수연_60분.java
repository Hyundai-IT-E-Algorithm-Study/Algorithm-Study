import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();

		int[] arr = new int[w];
		for (int i = 0; i < w; i++) {
			arr[i] = sc.nextInt();
		}

		int result = 0;

		for (int i = 1; i < w - 1; i++) { // 범위: 블록 양 끝에는 물이 고이지 않음
			int left = arr[i];
			int right = arr[i];

			// 가장 높은 블록 찾기(아이디어 참조)
			for (int j = 0; j <= i; j++) {
				left = Math.max(left, arr[j]);
			}

			for (int j = i; j < w; j++) {
				right = Math.max(right, arr[j]);
			}

			// 빗물의 양 계산
			result += Math.min(left, right) - arr[i];
		}

		System.out.println(result);
	}

}
