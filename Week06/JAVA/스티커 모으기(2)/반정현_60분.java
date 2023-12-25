class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;

        if (n <= 3) {
            int max = Integer.MIN_VALUE;
            for (int num : sticker) {
                max = Math.max(max, num);
            }
            return max;
        }

        int[] dp = new int[n];
        dp[0] = sticker[0];
        dp[1] = Math.max(sticker[0], sticker[1]);

        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }

        int maxSum = Math.max(dp[n - 2], dp[n - 3]);

        dp[0] = 0;
        dp[1] = sticker[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }

        answer = Math.max(maxSum, dp[n - 1]);

        return answer;
    }
}
