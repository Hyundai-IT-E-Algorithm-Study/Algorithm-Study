class Solution {
    public int solution(int sticker[]) {
        int leng = sticker.length;
        if(leng == 1) return sticker[0];
        else if(leng == 2) return Math.max(sticker[0], sticker[1]);
        
        int[] dpFirst = new int[leng];
        int[] dpSecond = new int[leng];
        
        for(int i = 0; i < leng; i++) {
            dpFirst[i] = sticker[i];
            dpSecond[i] = sticker[i];
        }
        
        dpFirst[1] = 0; // 첫번째 스티커를 떼었으므로 두번째 스티커는 못떼기 때문에 합하는 값을 0으로 줌
        dpSecond[0] = 0; // 두번째 스티커를 떼어 첫번째를 0
        dpFirst[2] += dpFirst[0];
        for (int i = 3; i < leng; i++) {
            dpFirst[i] += Math.max(dpFirst[i - 2], dpFirst[i - 3]);
            dpSecond[i] += Math.max(dpSecond[i - 2], dpSecond[i - 3]);
        }
        
        int firstMax = Math.max(dpFirst[leng - 2], dpFirst[leng - 3]);
        int secondMax = Math.max(dpSecond[leng - 1], dpSecond[leng - 2]);
        return Math.max(firstMax, secondMax);
    }
}
