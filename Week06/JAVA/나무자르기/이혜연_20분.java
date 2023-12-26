import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long max = 0;
		
		int[] height = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			height[i] = Integer.parseInt(st2.nextToken()); 
			max = Math.max(max, height[i]);
		}
		
		long start = 0;
		long end = max;
	
		
		while(start <= end) {
			long mid = (start+end)/2;
			long sum = 0;
			
			for(int i=0;i<N;i++) {
				if(height[i]>mid)
					sum+=height[i]-mid;
			}
				
			if(sum>=M)
				start = mid+1;
			else
				end=mid-1;
		}
		
		System.out.println(end);
		
		
	}
}
