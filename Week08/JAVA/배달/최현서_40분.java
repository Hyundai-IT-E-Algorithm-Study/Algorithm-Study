import java.util.*;

//다익스트라 최소거리배열을 만들고,
//K이하인 수를 세서 출력
public class Solution {

    public int solution(int N, int[][] road, int K) {
        //인접리스트 생성
        List<ArrayList<Node>> G = new ArrayList<>();
        for (int i=0; i<N+1; i++) {
            G.add(new ArrayList<Node>());
        }
        //최소거리배열 생성
        int INF = (int) 1e9;
        int[] D = new int[N+1];
        Arrays.fill(D, INF);
        //우선순위큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //visited 생성
        boolean[] visited = new boolean[N+1];

        //생성한 것들 각각 초기화("양방향", "여러간선 가능성" 고려)
        D[1] = 0;//시작점까진 거리 0
        visited[1] = true;
        for (int[] edge : road){
            G.get(edge[0]).add(new Node(edge[1], edge[2]));
            G.get(edge[1]).add(new Node(edge[0], edge[2]));
            if(edge[0]==1 && D[edge[1]] > edge[2]){
                D[edge[1]] = edge[2];
                pq.add(new Node(edge[1], edge[2]));
            }
            if(edge[1]==1 && D[edge[0]] > edge[2]){
                D[edge[0]] = edge[2];
                pq.add(new Node(edge[0], edge[2]));
            }
        }
        //다익스트라 수행
        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int currTown = currNode.getIndex();
            int dist = currNode.getDistance();
            visited[currTown] = true;

            for (Node adjNode : G.get(currTown)){
                int adjTown = adjNode.getIndex();
                int adjDist = adjNode.getDistance();
                if (visited[adjTown]) continue;
                if (D[adjTown] > dist+adjDist){
                    D[adjTown] = dist+adjDist;
                    pq.add(new Node(adjTown, dist+adjDist));
                }
            }
        }
        //정답 구하기
        int answer = 0;
        for (int minDist : D){
            if (minDist <= K) answer++;
        }
        return answer;
    }





      //Node 클래스..(우선순위큐와 인접리스트에 마을번호와 거리(시간)을 넣기위한 용도)
      class Node implements Comparable<Node> {

        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return this.index;
        }

        public int getDistance() {
            return this.distance;
        }

        // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }

}
