import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr1;
	static int[] arr2;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		arr1 = new int[N];
		for (int i = 0; i < N; i++) {
			arr1[i] = sc.nextInt();
		}

		arr2 = new int[N];
		visited = new boolean[N];

		dfs(0);
		System.out.println(result);
	}

	public static int dfs(int num) {
		if (num == N) { // 모든 노드를 방문했다면
			int sum = 0;
			for (int k = 1; k < N; k++) {
				sum += Math.abs(arr2[k - 1] - arr2[k]);
				result = Math.max(sum, result);
			}

			return result;
		}

		// 모든 노드 방문 전
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				arr2[num] = arr1[i];
				visited[i] = true;
				dfs(num + 1);
				visited[i] = false;
			}
		}

		return result;
	}

}
