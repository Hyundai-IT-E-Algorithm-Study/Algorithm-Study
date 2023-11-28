import java.io.*;

public class Main {
    static int[][] dp = new int [1001][1001];
    static String[] s1;
	static String[] s2;
    static String result = "";
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        s1 = br.readLine().split("");
		s2 = br.readLine().split("");
        
        result = lcs();
        bw.write(result.length());
        if(result.length() != 0) {
            bw.write(result);
        }
        
        bw.flush();
		bw.close();
    }
    
    public static String lcs() {
        // 테이블 구조
        for(int i = 0; i < s1.length; i++) {
            for(int j = 0; j < s2.length; j++) {
                if(s1[i].equals(s2[j])) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        int x = s1.length;
        int y = s2.length;
        String s = "";
        
        while(x!=0 && y!=0) {
            if(s1[x-1].equals(s2[y-1])) {
                s = s1[x-1];
            }
            else if(dp[x-1][y] == dp[x][y]) {
                x = x - 1;
            } 
            else if(dp[x][y-1] == dp[x][y]) {
                y = y - 1;
            } else {
                x = x - 1;
                y = y - 1;
            }
        }
        
        for(int k = s.length() - 1; k >= 0; k--) {
            result += s.charAt(k);
        }
        return result;
    }
}
