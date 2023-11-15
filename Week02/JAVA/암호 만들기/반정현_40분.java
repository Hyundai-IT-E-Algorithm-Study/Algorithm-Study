import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static char[] alphabet;
	public static int L,C;
	public static void backtracking(int start, int n, int k, int cnt, Stack<Character> result, StringBuilder builder) {
		if(k==0 && cnt>0 && (L-cnt)>1) {
			builder.append(result.toString().replaceAll("[\\[\\],\\s]", "")+'\n');
			return;
		}
		for (int i=start;i<n;i++) {
			result.add(alphabet[i]);
			if(alphabet[i]=='a'||alphabet[i]=='e'||alphabet[i]=='o'||alphabet[i]=='u'||alphabet[i]=='i') cnt++;
			backtracking(i+1,n,k-1,cnt,result,builder);
			char test=result.pop();
			if(test=='a'||test=='e'||test=='o'||test=='u'||test=='i') cnt--;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		L=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		alphabet=new char[C];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<C;i++) {
			alphabet[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(alphabet);
		
		StringBuilder sb=new StringBuilder("");
		backtracking(0,C,L,0, new Stack<Character>(),sb);
		System.out.println(sb.toString());
	}

}
