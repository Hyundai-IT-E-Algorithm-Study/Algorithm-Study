import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
    	
    	
        Arrays.sort(lottos);
        Arrays.sort(win_nums);  
            
        int[] correct = {0,0};
        int start = 0;
        
        for (int i=0; i<6; i++) {
            if (lottos[i] == 0) {
                correct[0]++;
                continue;
            } 
            for(int j=start; j<6; j++) {
            	if(lottos[i]==win_nums[j]) {
            		correct[0]++;
            		correct[1]++;
            		start=j+1;
            	}
            }
        }
        
        int[] answer = {0,0};
        
        for (int i=0; i<2; i++){
        switch(correct[i]) {
            case 0 :
                answer[i] = 6;
                break;
            default :
                answer[i] = 7-correct[i];
                break;          
            }
        }
        
        return answer;
    }
}
