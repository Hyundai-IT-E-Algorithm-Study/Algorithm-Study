// 1번 문제
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[][] visited;
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int R, C, sheep, wolf;
	static int sheep_cnt = 0;
	static int wolf_cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String animal = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = animal.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != '#') {
					bfs(i, j);
				}
			}
		}

		System.out.println(sheep_cnt + " " + wolf_cnt);
	}

	public static void bfs(int x, int y) {
		Queue<Integer> queue_x = new LinkedList<>();
		Queue<Integer> queue_y = new LinkedList<>();
		queue_x.offer(x);
		queue_y.offer(y);

		visited[x][y] = true;

		sheep = 0;
		wolf = 0;
		if (map[x][y] == 'k') {
			sheep++;
		}

		else if (map[x][y] == 'v') {
			wolf++;
		}
		while (!queue_x.isEmpty()) {
			int xx = queue_x.poll();
			int yy = queue_y.poll();

			for (int k = 0; k < 4; k++) {
				int temp_x = xx + dx[k];
				int temp_y = yy + dy[k];

				if (temp_x >= 0 && temp_y >= 0 && temp_x < R && temp_y < C) {
					if (!visited[temp_x][temp_y] && map[temp_x][temp_y] != '#') {
						visited[temp_x][temp_y] = true;

						if (map[temp_x][temp_y] == 'k') {
							sheep++;
						}

						else if (map[temp_x][temp_y] == 'v') {
							wolf++;
						}

						queue_x.offer(temp_x);
						queue_y.offer(temp_y);
					}
				}
			}
		}

		if (sheep > wolf) {
			sheep_cnt += sheep;
		} else {
			wolf_cnt += wolf;
		}
	}
}

// 2번 문제
import java.util.Scanner;

public class Main {
	static int N, M, R, num;
	static int[][] map;
	static int[][] temp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < R; i++) {
			num = sc.nextInt();

			switch (num) {
			case 1:
				one();
				break;

			case 2:
				two();
				break;

			case 3:
				three();
				break;

			case 4:
				four();
				break;

			case 5:
				five();
				break;

			case 6:
				six();
				break;
			}
		}

		// 결과 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void one() {
		temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[N - i - 1][j] = map[i][j];
			}
		}

		copyTempToMap();
	}

	public static void two() {
		temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][M - j - 1] = map[i][j];
			}
		}

		copyTempToMap();
	}

	public static void three() {
		temp = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[j][N - i - 1] = map[i][j];
			}
		}

		int tmp = N;
		N = M;
		M = tmp;

		map = temp;
	}

	public static void four() {
		temp = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[M - j - 1][i] = map[i][j];
			}
		}

		int tmp = N;
		N = M;
		M = tmp;

		map = temp;
	}

	public static void five() {
		temp = new int[N][M];

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j + M / 2] = map[i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i + N / 2][j] = map[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i][j - M / 2] = map[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i - N / 2][j] = map[i][j];
			}
		}

		copyTempToMap();
	}

	public static void six() {
		temp = new int[N][M];

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i + N / 2][j] = map[i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i][j - M / 2] = map[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i - N / 2][j] = map[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j + M / 2] = map[i][j];
			}
		}

		copyTempToMap();
	}

	public static void copyTempToMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }
}
