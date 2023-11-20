import java.util.*;

//정확성 64.3 효율성 35.7
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length; 
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        //0은 했으니 1부터
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                //삼각형의 모서리일때와 중간일때를 나눠서 계산
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                    //중간일 때 오는 값이 많지만, 문제는 최대값이기에 dp+ max 사용
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        //최하 층에서 최대값
        for (int num : dp[triangle.length - 1]) {
            answer = Math.max(answer, num);
        }
        
        return answer;
    }
}
