class Solution {
    static boolean check(int[] stones, int k, int friend){
        int cnt = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]<friend){
                cnt++;
            }
            else
                cnt = 0;
            if(cnt == k)
                return false;
        }
        return true;
    }
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200000000;
        
        while(min<=max){
            int mid = (min+max)/2;
            
            if(check(stones, k, mid)){
                min = mid + 1;
                answer = Math.max(answer,mid);
            }
            else
                max = mid-1;
        }
        
        return answer;
    }
}
