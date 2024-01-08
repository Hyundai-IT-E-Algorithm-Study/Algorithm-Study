import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M, N, date;
    static int[][] box;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 가로
        N = sc.nextInt(); // 세로

        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) { // 익은 토마토의 위치인 경우
                    queue.offer(new int[]{i, j, 0}); // 해당 위치의 좌표와 함께 일수를 0으로 초기화하여 큐에 추가 (아이디어 얻음) 
                                                     // => 이러면 1과 인접한 애들한테 영향 줄 때 큐에서 1의 위치를 얻을 수 있어서 편함 
                }
            }
        }

        date = bfs(queue);
        System.out.println(checkAllTomatoes() ? date : -1);
    }

    public static int bfs(Queue<int[]> queue) {
        int dayCount = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 익은 토마토 현재 위치와 현재 일수 담을 배열 생성 (아이디어 얻음)
            int x = current[0];
            int y = current[1];
            dayCount = current[2];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = 1; // 익은 토마토로 바꿔주기
                    queue.offer(new int[]{nx, ny, dayCount + 1}); // (아이디어 얻음)
                }
            }
        }

        return dayCount;
    }

    public static boolean checkAllTomatoes() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return false; // bfs를 다 돌렸음에도 아직 익지 않은 토마토가 존재할 경우
                }
            }
        }
        
        return true; // 모든 토마토가 익었을 경우
    }
}
