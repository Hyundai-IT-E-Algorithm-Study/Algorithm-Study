import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int S;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();

		visited = new boolean[1001][1001];

		bfs();
	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 1, 0 });
		visited[0][1] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int clipboard = current[0];
			int browser = current[1];
			int time = current[2];

			if (browser == S) {
				System.out.println(time);
				return;
			}

			// 1번 연산
			queue.offer(new int[] { browser, browser, time + 1 });

			// 2번 연산
			if (clipboard != 0 && browser + clipboard <= S && !visited[clipboard][browser + clipboard]) {
				queue.offer(new int[] { clipboard, browser + clipboard, time + 1 });
				visited[clipboard][browser + clipboard] = true;
			}

			// 3번 연산
			if (browser > 0 && !visited[clipboard][browser - 1]) {
				queue.offer(new int[] { clipboard, browser - 1, time + 1 });
				visited[clipboard][browser - 1] = true;
			}
		}
	}
}
