import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n=triangle.length;
        int[][] dp=new int[n][n];
        dp[0][0]=triangle[0][0];

        
        for (int i=1;i<triangle.length;i++) {
        	dp[i][0]=dp[i-1][0]+triangle[i][0];
        	int n2=triangle[i].length;
        	for (int j=1;j<n2-1;j++) {
        		dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
        	}
        	dp[i][n2-1]=dp[i-1][n2-2]+triangle[i][n2-1];
        }
        for(int ans:dp[triangle.length-1]) {
        	if (answer<ans) answer=ans;
        }
        return answer;
    }
}
