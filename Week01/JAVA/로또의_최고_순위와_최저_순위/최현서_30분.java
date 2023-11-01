import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
    	
    	//각 배열 오름차순 정렬
        Arrays.sort(lottos);
        Arrays.sort(win_nums);  
            
        int[] correct = {0,0}; //맞춘 개수 : index 0은 최대, 1은 최소
        int start = 0;
        
        for (int i=0; i<6; i++) {
        	//0이면, 최대 맞춘 개수만 1 증가
            if (lottos[i] == 0) {
                correct[0]++;
                continue;  
            } 
            //0이 아닐땐, 반복문으로 각각 맞춰보기
            for(int j=start; j<6; j++) {
            	if(lottos[i]==win_nums[j]) {
            		correct[0]++;
            		correct[1]++;
            		start=j+1; //맞춘게 있을 땐 각각 오름차순이기에, start를 그 이후로 설정(불필요한 비교 방지)
            	}
            }
        }
        
        int[] answer = {0,0}; // 순위: index 0은 최고순위, 1은 최저순위
        
        for (int i=0; i<2; i++){
        	answer[i] = (correct[i] ==0) ? 6 : 7-correct[i];  //0을 제외하곤 7에서 맞춘개수를 뺀것과 순위가 같음
        }
        return answer;
    }
}
