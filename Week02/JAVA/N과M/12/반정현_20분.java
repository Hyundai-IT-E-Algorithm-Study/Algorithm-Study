import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	public static void backtracking(int start, int k, Stack<Integer> result,StringBuilder builder) {
		if (k==0){
			builder.append(result.toString().replaceAll("[\\[\\],]","")+'\n');
			return;
		}
		for (int i=start;i<N;i++) {
			if (i>start && arr[i]==arr[i-1]) continue; 
			result.add(arr[i]);
			backtracking(i,k-1,result,builder);
			result.pop();
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		arr=new int[N];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb=new StringBuilder("");
		backtracking(0,M,new Stack<Integer>(),sb);
		System.out.println(sb.toString());
	}

}
