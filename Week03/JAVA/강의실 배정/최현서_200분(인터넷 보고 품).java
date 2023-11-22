//도저히 그리디 방법을 찾지못해서 인터넷에 검색해보았습니다.
//검색해보니 모두 '우선순위큐'를 이용하는 알고리즘이었습니다.
//그리드에서 '우선순위큐'를 적용하는 구현을 배울 수 있는 좋은 계기가 되었습니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = null;
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		br =  new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		
		int[][] lecture = new int[N][2];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			lecture[i][0] = Integer.parseInt(st.nextToken());
			lecture[i][1] = Integer.parseInt(st.nextToken());
		}

		//강의시간 2차원배열을 시작시간 오름차순 순서로 정렬(람다식 활용 방법)
		Arrays.sort(lecture, (o1, o2) -> {
		    return o1[0] - o2[0]; // 오름차순 정렬
		});
		
		//방을 담을 수 있는 우선순위 큐 선언
		PriorityQueue<Integer> room = new PriorityQueue<>();

		//제일 처음 강의 끝나는 시간 우선순위큐에 넣음
		room.offer(lecture[0][1]);
		
		for(int i=1; i<N; i++) {
			//시작시간 순으로 정렬했기에,(왼쪽 고려 안해도 됨) 끝나는 시간이 다음 시작시간보다 작거나 같으면(오른쪽이면,)
			//같은 강의실 배정이 가능한 것임.
			
			//우선순위큐에서 가장 끝나는 시간이 빠른 값 반환
			//이 값보다 강의 시작시간이 빠르다면, 
			//이것은 현재 우선순위큐에 있는 모든 방에 다 못들어 간다는 의미
			//따라서 새로운 방을 만들어줘서 끝나는 시간 넣어줌
			if (room.peek() > lecture[i][0]) {
				room.offer(lecture[i][1]);
			}
			else {
			//시작시간이 느리다면 현재 방에 들어갈 수 있음
			//따라서 가장 종료시간 빠른 강의를 큐에서 빼내고
			//해당 끝나는 시간을 넣어줌으로서 방 교체
				room.poll();
				room.offer(lecture[i][1]);
			}
		}
		//우선순위큐의 길이는 당연히 최소 방의 크기와 같다.
		System.out.println(room.size());
			
	}
}
