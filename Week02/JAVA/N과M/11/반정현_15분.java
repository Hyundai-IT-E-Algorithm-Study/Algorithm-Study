
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;
	public static void backtracking(int k, Stack<Integer> result,StringBuilder builder) {
		if (k==0){
			builder.append(result.toString().replaceAll("[\\[\\],]","")+'\n');
			return;
		}
		for (int i=0;i<N;i++) {
			if (i>0 && arr[i]==arr[i-1] && !visited[i-1]) continue; 
			//if (visited[i]) continue;
			result.add(arr[i]);
			visited[i]=true;
			backtracking(k-1,result,builder);
			visited[i]=false;
			result.pop();
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		arr=new int[N];
		visited=new boolean[N];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb=new StringBuilder("");
		backtracking(M,new Stack<Integer>(),sb);
		System.out.println(sb.toString());
	}

}
