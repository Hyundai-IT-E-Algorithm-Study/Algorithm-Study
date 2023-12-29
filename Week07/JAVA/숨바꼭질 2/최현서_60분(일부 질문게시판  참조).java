import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

    //최단 거리인데, N,K중 가장 큰값의 2배보다 크게 갈 필요가 없다.
		int maxSpot = Math.max(N, K)*2;
    //최소시간은 둘 사이의 간격보다는 무조건 작거나 같다.
		int minTime = Math.abs(N-K);
		
		int cnt = 0;
		
		//bfs start
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> t = new LinkedList<>();
		q.offer(N);
		t.offer(0);
		boolean[] visited = new boolean[maxSpot+1];
		while(!q.isEmpty()) {
			int currSpot = q.poll();
			int currTime = t.poll();
			//BFS기에 가능한 로직
			if (currSpot == K) {
				if (currTime < minTime) minTime = currTime;
        //현재레벨에서 K와 같은 것들은 모두 이 cnt를 1씩 증가시킬수밖에 없음.
				if (currTime == minTime) cnt++;
        //더 level이 커졌다는건 해당 시간대의 BFS는 끝이 났다는 의미 => 더이상 셀 필요 없음.
				if (currTime > minTime) break;
			}
			
			visited[currSpot] = true; // "visited를 이 시점에 넣어야한다!! -> 질문게시판 참조" 
      //반복을 없애기위해 visited는 필요. 하지만 같은 레벨에선 같은 것이 들어갈 수 있다!! => 이것이 이 문제의 핵심.
			for(int i=0; i<3; i++) {
				int nextSpot = i==0? currSpot+1: i==1? currSpot-1 : currSpot*2;
				if (0<=nextSpot && nextSpot <=maxSpot && !visited[nextSpot]) {
					q.offer(nextSpot);
					t.offer(currTime+1);
				}
			}
			
		}
		System.out.println(minTime);
		System.out.println(cnt);

	}

}
