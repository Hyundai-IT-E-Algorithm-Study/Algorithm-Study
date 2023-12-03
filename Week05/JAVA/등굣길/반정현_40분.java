class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            if (!containsPuddle(puddles, 1, i + 1)) {
                dp[i][0] += dp[i - 1][0];
            }
        }

        for (int j = 1; j < m; j++) {
            if (!containsPuddle(puddles, j + 1, 1)) {
                dp[0][j] += dp[0][j - 1];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (containsPuddle(puddles, j + 1, i + 1)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000007;
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    private static boolean containsPuddle(int[][] puddles, int x, int y) {
        for (int[] puddle : puddles) {
            if (puddle[0] == x && puddle[1] == y) {
                return true;
            }
        }
        return false;
    }
}
