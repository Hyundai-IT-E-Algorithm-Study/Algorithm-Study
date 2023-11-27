import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String seq1 = sc.next();
    //1번째 인덱스부터 시작하기 위해서 앞에 공백 넣어줌
		seq1 = " ".concat(seq1);
		String seq2 = sc.next();
		seq2 = " ".concat(seq2);
		int len1 = seq1.length();
		int len2 = seq2.length();
		
		int[][] DP = new int[len2][len1];

    //첫번째수열중 x길이만큼과, 두번째수열중 y길이만큼에 대해서
    //최대 LCS를 넣는 DP
		for (int y=1; y<len2; y++) {
			for (int x=1; x<len1; x++) {
        //규칙1)두 값이 같을 땐, 전에 두값을 포함하는 최대값에서 1을 더해줌 
				if (seq1.charAt(x) == seq2.charAt(y)) {
					DP[y][x] = DP[y-1][x-1] + 1;
				}
        //규칙2)두 값이 다를 땐, 두값 중 하나를 포함하는 DP값의 최대와 같다.
				else {
					DP[y][x] = Math.max(DP[y-1][x], DP[y][x-1]);
				}
			}
		}
    //LCS 구함(맨끝값이 무조건 최대-모든 수열을 다 포함한 것중 최대값이기에)
		System.out.println(DP[len2-1][len1-1]);

    //최대 LCS에 해당하는 수열을 찾기 위해서
    //위의 과정을 역추적함
		int y = len2-1;
		int x = len1-1;
		String ans = "";
		while(DP[y][x]>0) {
			if (seq1.charAt(x) == seq2.charAt(y)) {
				ans = (seq1.substring(x,x+1)).concat(ans);
				y--;
				x--;
			}
			else {
				if (DP[y-1][x] > DP[y][x-1]) y--;
				else x--;
			}
		}
		System.out.println(ans);
	}
}
