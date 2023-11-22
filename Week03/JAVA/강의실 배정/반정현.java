import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Time_room implements Comparable<Time_room>{
	private int start;
	private int end;
	public Time_room(int start,int end) {
		this.start=start;
		this.end=end;
	}
	public int get_start() {
		return this.start;
	}
	public int get_end() {
		return this.end;
	}
	@Override
    public int compareTo(Time_room other) {
        return Integer.compare(this.start, other.start);
	}
    
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Time_room> room=new PriorityQueue<>();
		PriorityQueue<Integer> ans=new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int s=Integer.parseInt(st.nextToken());
			int t=Integer.parseInt(st.nextToken());
			room.add(new Time_room(s, t));
		}
		while (!room.isEmpty()) {
			Time_room tr=room.poll();
			int ns=tr.get_start();
			int nt=tr.get_end();
			if (ans.isEmpty()) ans.add(nt);
			else {
				if(ns<ans.peek()) ans.add(nt);
				else {
					ans.poll();
					ans.add(nt);
				}
			}
			
		}
		System.out.println(ans.size());
				
	}

}
