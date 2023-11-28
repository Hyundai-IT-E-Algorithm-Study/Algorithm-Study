import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine().trim();
        String str2 = br.readLine().trim();

        int n1 = str1.length();
        int n2 = str2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];


        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int mx = dp[n1][n2];
        char[] result=new char[mx];
        int y = n1;
        int x = n2;
        int[] dy = {-1, 0};
        int[] dx = {0, -1};

        while (dp[y][x] != 0) {
            boolean flag = false;

            for (int i = 0; i < 2; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (dp[ny][nx] == mx) {
                    y = ny;
                    x = nx;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                mx--;
                result[mx]=str1.charAt(y - 1);
                y--;
                x--;
            }
        }

        System.out.println(dp[n1][n2]);
        System.out.println(String.valueOf(result));
        
    }

}
