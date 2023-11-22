import java.util.*;

public class Main {
	public static void main(String[] args) {
       	Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] time = new int[N][2];
        for (int i = 0; i < N; i++) {
            time[i][0] = sc.nextInt(); //Si
            time[i][1] = sc.nextInt(); //Ti
        }
        
        // 강의 시작 시간을 기준으로 오름차순 정렬(아이디어 get from gpt)
        Arrays.sort(time, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int start = time[i][0];
            int end = time[i][1];
            if (!pq.isEmpty() && start >= pq.peek()) {
                pq.poll(); // 다음 수업 시작 시간이 우선순위 큐의 맨 위에 있는 종료 시간보다 나중이거나 같은 경우, 해당 강의실을 다시 사용할 수 있으므로 poll()을 통해 우선순위 큐에서 제거
                pq.offer(end); // 종료된 강의가 빠진 해당 강의실에 새로운 강의 종료 시간 추가
            } else {
                pq.offer(end); // 비어 있는 큐에 강의 종료 시간을 추가
            }
        }
        System.out.println(pq.size()); // 남아있는 큐의 크기가 강의실 최종 개수
	}
}
