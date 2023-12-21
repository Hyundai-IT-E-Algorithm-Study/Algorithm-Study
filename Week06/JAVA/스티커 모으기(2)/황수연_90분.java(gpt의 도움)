class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        if (sticker.length == 1) { // 스티커가 하나뿐인 경우
            return sticker[0];
        }

        // 1. 첫 번째 스티커를 떼는 경우
        // dp1은 sticker의 최대값을 저장하는 배열
        int[] dp1 = new int[sticker.length];
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        for (int i = 2; i < sticker.length - 1; i++) {
        	// dp1[i - 1]은 현재 스티커를 떼지 않고 이전 스티커를 떼었을 때의 최대값 
        	// dp1[i - 2] + sticker[i]는 현재 스티커를 뗄 경우, 그 이전의 두 번째 스티커까지의 최대값에 현재 스티커를 더한 값
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // 2. 첫 번째 스티커를 떼지 않는 경우
        int[] dp2 = new int[sticker.length];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        answer = Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);

        return answer;
    }
}
