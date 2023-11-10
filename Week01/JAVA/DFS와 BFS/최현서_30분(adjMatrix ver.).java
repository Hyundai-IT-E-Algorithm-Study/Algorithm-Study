//다른 분들거 참조해서 풀었습니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	static BufferedReader br = null;
	static StringTokenizer st = null;
	static int[][] adjMatrix = null;
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
		adjMatrix = new int[N+1][N+1]; //숫자를 문제대로 1부터 넣기 위해서 N+1, 인덱스 0은 안쓰임
		//int배열이라 각각 0으로 초기화
		
		for (int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); 
			int to   = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
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
		
		for (int node=1; node <= N; node++) {
			if(!isVisited[node] && (adjMatrix[currNode][node] == 1)) {
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
			for (int node=1; node <= N; node++) { 
				if(adjMatrix[currNode][node] == 1 && !isVisited[node]) {
					q.offer(node);
					isVisited[node] = true;
				}
			}
		}
	}
}
