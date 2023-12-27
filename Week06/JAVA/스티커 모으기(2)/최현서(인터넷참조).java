class Solution {
    public int solution(int[] sticker) {
        int stickerNum = sticker.length;
        
        //원형이라, dp 2개 사용
        //맨처음거 포함하는 dp1
        int[] dp1 = new int[stickerNum];
        //맨처음거 포함 안하는 dp2
        int[] dp2 = new int[stickerNum];

        int dp1max = 0;
        int dp2max = 0;

        for (int i=0; i< stickerNum; i++){
            if (i==0){
                dp1[i] = sticker[i];
                dp1max = dp1[i];
            }
            if (i==1){
                dp1[i] = dp1[0];
                dp2[i] = sticker[i];
                dp2max = dp2[i];
            }

            if (1<i) {
                dp2[i]= Math.max(dp2[i-2]+sticker[i], dp2[i-1]);
                dp2max = dp2[i];
                if(i<=stickerNum-2){
                    dp1[i] = Math.max(dp1[i-2]+sticker[i], dp1[i-1]);
                    dp1max = dp1[i];
                }
            }
        }
        return Math.max(dp1max, dp2max);
    }
}
