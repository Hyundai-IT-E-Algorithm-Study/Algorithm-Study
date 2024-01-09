import java.util.*;

public class Main {
    private static int target;
    private static boolean[][] visited; 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        target = scanner.nextInt();
        visited = new boolean[target + 2][target + 2]; 
        System.out.println(bfs(1, 0));
        scanner.close();
    }

    public static int bfs(int start, int cnt) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, cnt, 0));
        visited[start][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.node == target) {
                return current.cnt;
            }

            int[] nextMoves;
            if (current.cb == 0) {
                nextMoves = new int[]{current.node - 1, current.node};
            } else {
                nextMoves = new int[]{current.node - 1, current.node + current.cb, current.node};
            }

            for (int nextNode : nextMoves) {
                int nextCb = nextNode == current.node ? current.node : current.cb;
                if (nextNode >= 0 && nextNode <= target && !visited[nextNode][nextCb]) {
                    visited[nextNode][nextCb] = true;
                    queue.add(new Node(nextNode, current.cnt + 1, nextCb));
                }
            }
        }
        return -1;
    }

    static class Node {
        int node;
        int cnt;
        int cb;

        Node(int node, int cnt, int cb) {
            this.node = node;
            this.cnt = cnt;
            this.cb = cb;
        }
    }
}
