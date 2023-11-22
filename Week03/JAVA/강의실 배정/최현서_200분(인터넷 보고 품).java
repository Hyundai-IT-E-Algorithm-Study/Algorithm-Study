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
		Arrays.sort(lecture, (o1, o2) -> {
		    return o1[0] - o2[0]; // 오름차순 정렬
		});
		
		
		PriorityQueue<Integer> room = new PriorityQueue<>();
		
		room.offer(lecture[0][1]);
		
		for(int i=1; i<N; i++) {
			if (room.peek() > lecture[i][0]) {
				room.offer(lecture[i][1]);
			}
			else {
				room.poll();
				room.offer(lecture[i][1]);
			}
		}
		
		System.out.println(room.size());
			
	}
}
