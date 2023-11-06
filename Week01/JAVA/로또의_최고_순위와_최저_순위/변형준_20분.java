class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zero = 0;
        // for문 0~5, 같은지 비교 같으면 cnt++
        // 0의 개수 저장, cnt에 0의 개수 더하면 최대
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0){
                zero++;
                continue;
            }
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i]==win_nums[j]){
                    cnt++;
                    break;
                }
            }
        }
        int high = 7-cnt-zero;
        int low = 7-cnt;  
        if(low==7) low = 6;
        if(high==7) high = 6;
        
        int[] answer = {high,low};
        return answer;
    }
}
