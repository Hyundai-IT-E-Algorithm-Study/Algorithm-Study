class Solution {
    static int rank(int cnt) {
		if(cnt == 6) return 1;
		else if(cnt == 5) return 2;
		else if(cnt == 4) return 3;
		else if(cnt == 3) return 4;
		else if(cnt == 2) return 5;
		else return 6;
	}
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_cnt = 0;
		int max_cnt = 0;
		int min_cnt = 0;
		for(int i=0;i<lottos.length;i++) {
			if(lottos[i]==0) {
				zero_cnt++;
				continue;
			}
			for(int j=0;j<win_nums.length;j++) {
				if(lottos[i]==win_nums[j]) {
					min_cnt++;
					break;
				}
			}
		}
		
		max_cnt = min_cnt+zero_cnt;

		answer[0] = rank(max_cnt);
		answer[1] = rank(min_cnt);
	
        return answer;
    }
}
