import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp = new int[1001][1001];
    static String[] str1;
    static String[] str2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //문자열 받아서 String 배열에 담기
        str1 = br.readLine().split("");
        str2 = br.readLine().split("");

        System.out.print(solve());
    }

    public static String solve() {
        int x = str1.length;
        int y = str2.length;

        // 테이블 그리기
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(str1[i].equals(str2[j])) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        // LCS dp의 마지막이 최대값
        sb.append(dp[x][y] + "\n");
        List<String> list = new ArrayList<>();

        // 가장 큰 값이 LCS이기 때문에 역순으로 탐색. 같을 때만 임시문자열에 담아줌
        while(x != 0 && y != 0) {
            if(str1[x - 1].equals(str2[y - 1])) {
                list.add(str1[x - 1]);
                x -= 1;
                y -= 1;
                // 다른 문자일 때, 테이블에서 오른쪽 아래에서 왼쪽 위 방향이므로
                // 왼쪽과 위쪽 중 큰 값을 가져왔기 때문에 맞춰주기 위해 해당 값을 빼줌
            } else if(dp[x][y] == dp[x - 1][y]) {
                x -= 1;
            } else if(dp[x][y] == dp[x][y - 1]) {
                y -= 1;
            }
        }
        
        //역순으로 가져왔기 때문에 다시 역순
        if(!list.isEmpty()){
            for(int i = list.size() - 1; i >= 0; i--){
                sb.append(list.get(i));
            }
        }
        
        return sb.toString();
    }
}
