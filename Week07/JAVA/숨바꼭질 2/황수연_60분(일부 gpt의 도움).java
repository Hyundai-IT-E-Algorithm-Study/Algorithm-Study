import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K;
	static int[] visited = new int[100001];
	static int[] count = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		bfs(N, K);
	}

	public static void bfs(int start, int target) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		visited[start] = 1;
		count[start] = 1;

		while (!queue.isEmpty()) {
			int current = queue.poll(); // 현재 위치
			if (current == target) {
				System.out.println(visited[current] - 1); // 아이디어 참조
				System.out.println(count[current]); // 아이디어 참조
				return;
			}

			int[] spots = { current - 1, current + 1, current * 2 }; // 다음 위치
			for (int spot : spots) {
				if (spot >= 0 && spot <= 100000) {
					if (visited[spot] == 0) {
						visited[spot] = visited[current] + 1; // 아이디어 참조
						count[spot] += count[current]; // 아이디어 참조
						queue.offer(spot);
					} else if (visited[spot] == visited[current] + 1) { // 아이디어 참조
						count[spot] += count[current]; // 아이디어 참조
					}
				}
			}
		}
	}
}
