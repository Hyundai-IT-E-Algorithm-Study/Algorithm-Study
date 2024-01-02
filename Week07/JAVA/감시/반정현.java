import java.util.*;
import java.io.*;

public class Main {
    static int N, M, min_value;
    static int[][] arr;
    static int[][][] directions_cctv = { {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}} };
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<int[]> cctv = new ArrayList<>();
    static ArrayList<Integer> directions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        min_value = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0 && arr[i][j] != 6) {
                    cctv.add(new int[] {i, j, arr[i][j]});
                }
            }
        }
        dfs(0);
        System.out.println(min_value);
    }

    static void watch(int x, int y, int[] direction,int[][] temp) {
        for (int d : direction) {
            int nx = x;
            int ny = y;
            while (true) {
                ny += dy[d];
                nx += dx[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && temp[nx][ny] != 6) {
                    if (temp[nx][ny] == 0) {
                        temp[nx][ny] = '#';
                    }
                } else {
                    break;
                }
            }
        }
    }

    static void dfs(int cnt) {
        if (cnt == cctv.size()) {
            int[][] temp = new int[N][M];
            for (int i = 0; i < N; i++) {
                temp[i] = arr[i].clone();
            }
            for (int i = 0; i < cctv.size(); i++) {
                watch(cctv.get(i)[0], cctv.get(i)[1], directions_cctv[cctv.get(i)[2]][directions.get(i)],temp);
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (temp[i][j] == 0) {
                        count++;
                    }
                }
            }
            min_value = Math.min(min_value, count);
            return;
        }

        int type = cctv.get(cnt)[2];
        for (int i = 0; i < directions_cctv[type].length;i++) {
            directions.add(i);
            dfs(cnt + 1);
            directions.remove(directions.size() - 1);
        }
    }
}
