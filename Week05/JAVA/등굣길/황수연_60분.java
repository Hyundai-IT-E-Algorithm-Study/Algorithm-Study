class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] dp = new int[m + 1][n + 1];
        
        // 물 웅덩이 정의
        for(int i = 0; i < puddles.length; i++) {
            dp[puddles[i][0]][puddles[i][1]] = -1; 
        }
        
        // 시작점 설정
        dp[1][1] = 1;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0; // 물 웅덩이인 경우 경로 없음으로 표시
                    continue;
                }
                if (i > 1 && dp[i - 1][j] != -1) {
                    dp[i][j] += dp[i - 1][j] % mod;
                }
                if (j > 1 && dp[i][j - 1] != -1) {
                    dp[i][j] += dp[i][j - 1] % mod;
                }
            }
        }
        return dp[m][n] % mod;
    }
}
