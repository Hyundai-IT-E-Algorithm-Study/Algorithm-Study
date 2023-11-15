import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N,M;
	static Stack<Integer> numStack = new Stack<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		makeSeq(1, "");
		
	}
	
	static void makeSeq(int num, String seq) {
		if(seq.length()==M*2) {
			System.out.println(seq);
			return;
		}
		if(num>N) return;
		
		makeSeq(num+1, seq.concat(num+" "));
		makeSeq(num+1, seq);
	}

}
