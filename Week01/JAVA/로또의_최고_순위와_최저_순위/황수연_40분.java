class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6,6,5,4,3,2,1}; // answer[] 차례대로 0개,1개,2개,3개,4개,5개,6개 번호가 일치
        int[] answer = new int[2]; // 최저순위: answer[0], 최고순위: answer[1]
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0){
                    answer[0]++;
            }else{
                for(int j=0; j<win_nums.length; j++){ 
                    if(lottos[i]==win_nums[j]){
                        answer[0]++;
                        answer[1]++;
                    }
                }
            }
        }
        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];
        return answer;
    }
}
