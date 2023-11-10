import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	static BufferedReader br = null;
	static StringTokenizer st = null;
	static ArrayList<ArrayList<Integer>> adjList = null; //인접 리스트 방식 사용 ArrayList안에 제너릭으로 ArrayList들어감
	static StringBuilder str = null;
	static boolean[] isVisited = null;
	static int N = 0;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		//숫자 읽기
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());   
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		
		//adjacency 완성
		adjList = new ArrayList<>();
		for (int i=1; i<=N+1; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		//int배열이라 각각 0으로 초기화
		
		
		for (int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); 
			int to   = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(to);
			adjList.get(to).add(from);
		}
		
		//각 노드의 인접리스트를 오름차순 정렬 해줘야함 
		//-> 따라서 이 문제에선 인접행렬을 쓰는게 더 좋음(크기순대로 탐색해야 하기떄문)
		for (int i=1; i <= N; i++) {
			Collections.sort(adjList.get(i));
		}
		
		//DFS 수행
		str = new StringBuilder();
		isVisited = new boolean[N+1];
		DFS(V);
		System.out.println(str);
		
		//BFS 수행
		str = new StringBuilder();
		isVisited = new boolean[N+1];
		BFS(V);
		System.out.println(str);
		

		//BufferedReader close
		br.close();
	}
	
	public static void DFS(int currNode) {
		str.append(currNode + " ");
		isVisited[currNode] = true;
		
		for (int node : adjList.get(currNode)) { //currNode의 인접리스트에 있는 노드만 확인
			if(!isVisited[node]) { //따라서 조건문엔 visited여부만 조사
				DFS(node);
			}
		}
	}
	
	
	public static void BFS(int startNode) {
		//시작 넣음
		Queue<Integer> q = new LinkedList<>();
		q.offer(startNode);
		isVisited[startNode] = true;
		
		//빼야하는데, 뺄게 없이 비었다? 종료
		while(!q.isEmpty()) {
			//큐 빼면서 출력
			int currNode = q.poll();
			str.append(currNode + " ");
			
			//인접한거 큐 넣음
			for (int node : adjList.get(currNode)) { //currNode의 인접리스트에 있는 노드만 확인
				if(!isVisited[node]) { //따라서 조건문엔 visited여부만 조사
					q.offer(node);
					isVisited[node] = true;
				}
			}
		}
	}
}
