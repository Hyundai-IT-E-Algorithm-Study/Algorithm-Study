class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0]; // 배열 초기화
        
        for(int i=1; i<triangle.length; i++) {
            // 왼쪽
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            
            for(int j=1; j<=i; j++) {
                if(j == i) { // 오른쪽 끝일 때
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else { // 중간일 때
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }
        int answer = 0;
        for(int k=0; k<triangle.length; k++) {
            answer = Math.max(answer, dp[triangle.length - 1][k]); // 삼각형의 맨 마지막줄에서 최종 최대값 찾기
        }
        return answer;
    }
}
