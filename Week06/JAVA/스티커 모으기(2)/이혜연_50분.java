import java.util.*;
class Solution {
    public int solution(int sticker[]) {
		int answer = 0;

        if(sticker.length == 1) return sticker[0];
		int[] dp = new int[sticker.length];
		dp[0] = sticker[0];
		dp[1] = sticker[0];
		//첫번째 스티커를 선택하면 마지막 스티커 선택x
		for(int i=2;i<sticker.length-1;i++) {
			dp[i] = Math.max(dp[i-1], sticker[i]+dp[i-2]);
		}
		answer = dp[sticker.length-2];
		
		dp[0] = 0;
		dp[1] = sticker[1];
		for(int i=2;i<sticker.length;i++) {
			dp[i] = Math.max(dp[i-1], sticker[i]+dp[i-2]);
		}
		answer = Math.max(answer, dp[sticker.length-1]);
    
        return answer;
    }
}
