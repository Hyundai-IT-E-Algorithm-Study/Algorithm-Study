import java.util.Scanner;

public class Main {
	static int M, N, ourCount, enemyCount;
	static boolean visited[][];
	static char[][] soldier;
	static String sol;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 가로
		M = sc.nextInt(); // 세로

		visited = new boolean[M][N];
		soldier = new char[M][N];

		// 군대 정의
		for (int i = 0; i < M; i++) {
			sol = sc.next();
			for (int j = 0; j < N; j++) {
				soldier[i][j] = sol.charAt(j);
			}
		}

		int our = 0;
		int enemy = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, soldier[i][j]);
					our += ourCount * ourCount; // 각 지역별로 계산해 누적 (아이디어 얻음)
					enemy += enemyCount * enemyCount;
					// 다음 지역으로 넘어가기 위해 초기화 (아이디어 얻음)
					ourCount = 0;
					enemyCount = 0;
				}
			}
		}

		System.out.println(our + " " + enemy);
	}

	public static void dfs(int x, int y, char s) {
		visited[x][y] = true;

		if (s == 'W')
			ourCount++;
		else
			enemyCount++;

		for (int k = 0; k < 4; k++) {
			int soldier_x = x + dx[k];
			int soldier_y = y + dy[k];

			if (soldier_x >= 0 && soldier_y >= 0 && soldier_x < M && soldier_y < N) {
				if (!visited[soldier_x][soldier_y] && soldier[soldier_x][soldier_y] == s) {
					dfs(soldier_x, soldier_y, s);
				}
			}
		}
	}

}
