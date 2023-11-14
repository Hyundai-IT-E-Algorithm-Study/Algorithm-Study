import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N,M;
	static Stack<Integer> numStack = new Stack<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		makeSeq();
		
	}
	
	static void makeSeq() {
		if(numStack.size()==M) {
			for(int num:numStack) {
				System.out.print(num+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<= N; i++) {
			if(!numStack.contains(i)) {
				numStack.push(i);
				makeSeq();
				numStack.pop();
			}
		}
	}

}
