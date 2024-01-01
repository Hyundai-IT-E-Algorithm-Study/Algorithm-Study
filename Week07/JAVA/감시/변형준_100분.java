import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] copy;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static LinkedList<Node> cctvList;
    static int[] dir;
    static int result = Integer.MAX_VALUE;

    static class Node {
        int cctvKind;
        int x;
        int y;

        public Node(int cctvKind, int x, int y) {
            super();
            this.cctvKind = cctvKind;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cctvList = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new Node(map[i][j], j, i));
                }
            }
        }

        dir = new int[cctvList.size()];
        sol(0, cctvList.size());

        System.out.println(result);

    }

    private static void sol(int depth, int cnt) {
        if (depth == cnt) {
            copy = new int[N][M];
            for (int i = 0; i < map.length; i++) {
                copy[i] = map[i].clone();
            }

            for (int i = 0; i < cnt; i++) {
                direction(cctvList.get(i), dir[i]);
            }
            noCCTV();
            return;
        }

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            dir[depth] = i;
            sol(depth + 1, cnt);
        }

    }

    private static void noCCTV() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) {
                    cnt++;
                }
            }
        }
        result = Math.min(result, cnt);
    }

    private static void direction(Node cctv, int dir) {
        int cctvKind = cctv.cctvKind;
        if (cctvKind == 1) {
            switch (dir) {
                case 0:
                    watch(cctv, 0); // 상
                    break;
                case 1:
                    watch(cctv, 1); // 우
                    break;
                case 2:
                    watch(cctv, 2); // 하
                    break;
                case 3:
                    watch(cctv, 3); // 좌
                    break;
            }
        } else if (cctvKind == 2) {
            if (dir == 0 || dir == 2) {
                watch(cctv, 0);
                watch(cctv, 2); // 상하
            } else if (dir == 1 || dir == 3) {
                watch(cctv, 1);
                watch(cctv, 3); // 좌우
            }
        } else if (cctvKind == 3) {
            switch (dir) {
                case 0:
                    watch(cctv, 0);
                    watch(cctv, 1); // 상우
                    break;
                case 1:
                    watch(cctv, 1);
                    watch(cctv, 2); // 우하
                    break;
                case 2:
                    watch(cctv, 2);
                    watch(cctv, 3); // 하좌
                    break;
                case 3:
                    watch(cctv, 3);
                    watch(cctv, 0); // 좌상
                    break;
            }
        } else if (cctvKind == 4) {
            switch (dir) {
                case 0:
                    watch(cctv, 3);
                    watch(cctv, 0);
                    watch(cctv, 1); // 좌상우
                    break;
                case 1:
                    watch(cctv, 0);
                    watch(cctv, 1);
                    watch(cctv, 2); // 상우하
                    break;
                case 2:
                    watch(cctv, 1);
                    watch(cctv, 2);
                    watch(cctv, 3); // 우하좌
                    break;
                case 3:
                    watch(cctv, 2);
                    watch(cctv, 3);
                    watch(cctv, 0); // 하좌상
                    break;

            }
        } else if (cctvKind == 5) {
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3); // 상우하좌
        }

    }

    //bfs
    private static void watch(Node cctv, int dir) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];

        queue.offer(cctv);
        visit[cctv.y][cctv.x] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nx = now.x + dx[dir];
            int ny = now.y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N || copy[ny][nx] == 6) {
                break;
            }

            if (copy[ny][nx] == 0) {
                copy[ny][nx] = -1;
                queue.offer(new Node(cctv.cctvKind, nx, ny));
            } else {
                queue.offer(new Node(cctv.cctvKind, nx, ny));
            }
        }
    }
}
