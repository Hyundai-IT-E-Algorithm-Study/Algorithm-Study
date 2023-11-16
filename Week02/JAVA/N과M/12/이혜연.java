import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet<ArrayList<Integer>> set = new LinkedHashSet<ArrayList<Integer>>();

	static private void dfs(int depth, int start, int[] arr) {
		if(depth==M) {
			ArrayList<Integer> listValues = new ArrayList<Integer>();
			for(int val : result) {
				listValues.add(val);
			}	
			
			set.add(listValues);			
			return;
		}
		
		for(int i=start; i<N; i++) {
			result[depth] = arr[i];
			dfs(depth+1, i, arr);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		arr = new int[N];
		result = new int[M];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		dfs(0, 0, arr);
	
		for(ArrayList<Integer> val : set) {
			for(int i=0;i<val.size();i++)
				sb.append(val.get(i) + " ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	
	}
}
