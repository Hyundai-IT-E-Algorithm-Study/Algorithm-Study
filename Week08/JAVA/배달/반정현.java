import java.util.*;

class Solution {
    static int[] distance;
    static List<List<Node>> graph;

    public static void dijkstra(int start) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.vertex;
            int dist = node.cost;

            if (distance[now] < dist) {
                continue;
            }

            for (Node n : graph.get(now)) {
                int cost = dist + n.cost;
                if (cost < distance[n.vertex]) {
                    distance[n.vertex] = cost;
                    queue.offer(new Node(n.vertex, cost));
                }
            }
        }
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int node1 = r[0];
            int node2 = r[1];
            int cost = r[2];

            graph.get(node1).add(new Node(node2, cost));
            graph.get(node2).add(new Node(node1, cost));
        }

        distance = new int[N + 1];
        dijkstra(1);

        for (int dis : distance) {
            if (dis <= K) {
                answer++;
            }
        }

        return answer;
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
