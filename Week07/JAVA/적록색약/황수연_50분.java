import java.util.Scanner;

public class Main {
	static int N;
	static String color;
	static char gallery[][];
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		gallery = new char[N][N];

		for (int i = 0; i < N; i++) {
			color = sc.next();
			for (int j = 0; j < N; j++) {
				gallery[i][j] = color.charAt(j); // 아스키코드값 변환
			}
		}

		visited = new boolean[N][N];

		// 색맹이 아닌 경우
		int sum1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					sum1++;
				}
			}
		}

		visited = new boolean[N][N];

		// 색맹인 경우 => 이건 왜 안되나?? 빨간색을 초록색으로 변경한 후에 dfs를 호출하면 해당 지점을 이미 방문한 것으로 표시되어 원래의 구역이 아닌 다른 곳 탐색 가능성
//		int sum2 = 0;
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (!visited[i][j]) {
//					if (gallery[i][j] == 'R') {
//						gallery[i][j] = 'G';
//						dfs(i, j);
//						sum2++;
//					}
//				}
//			}
//		}

    // gpt의 도움
		int sum2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (gallery[i][j] == 'R') {
					gallery[i][j] = 'G';
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					sum2++;
				}
			}
		}

		System.out.println(sum1 + " " + sum2);
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int k = 0; k < 4; k++) {
			int color_x = x + dx[k];
			int color_y = y + dy[k];

			if (color_x >= 0 && color_y >= 0 && color_x < N && color_y < N) {
				if (!visited[color_x][color_y] && gallery[color_x][color_y] == gallery[x][y]) {
					dfs(color_x, color_y);
				}
			}
		}
	}

}
