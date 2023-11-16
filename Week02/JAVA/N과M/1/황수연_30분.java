import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N+1];
        arr = new int[M+1];

        dfs(N, M, 0); // 깊이는 0부터 시작
    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) { // 순열의 길이가 M인지 조건부터 우선 확인
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) { // 아직 순열의 길이가 M이 아니라면 실행
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}
