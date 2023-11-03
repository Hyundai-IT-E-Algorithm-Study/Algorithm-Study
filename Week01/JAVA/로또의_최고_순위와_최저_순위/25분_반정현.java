
package day1;
  

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
    	// answer[0] : 당첨 가능한 최고 순위 
    	// answer[1] : 최저 순위
    	int[] answer = new int[2];
        
        // 1. 민우가 구매한 로또 번호 여부를 조사한 visited 배열
        // lottos의 모든 원소는 0 이상 45 이하인 정수
        // 도메인 숫자 범위가 한정되어 있으므로 visited 배열로 처리
        boolean[] visited=new boolean[46];
        
        // 당첨 가능한 최소 순위 : 알아볼 수 없는 번호(0)이 모두 틀린 경우, 최대 순위 : 알아볼 수 없는 번호(0)이 모두 맞은 경우
        // 민우가 구매한 로또 번호 인덱스의 값을 true로, 0의 개수는 따로 answer[0]에 저장
        for(int i:lottos) {
        	if (i!=0) visited[i]=true;
        	else answer[0]+=1;
        } 
        
        // 2. 당첨 번호를 담은 배열 win_nums와 민우가 구매한 로또 번호가 몇 개 일치하는지 조사
        // 민우가 당첨 번호를 몇 개 체크(방문; 배열 값 true)했는지 
        for(int j:win_nums) {
        	if(visited[j]) answer[1]+=1;
        }
        
        // answer[0] : '0'이 모두 맞았을 경우 민우의 당첨 번호 개수
        // answer[1] : '0'이 모두 틀렸을 경우 민우의 당첨 번호 개수
        answer[0]+=answer[1];
        
        
        // 3. 당첨 번호를 기준으로 순위 계산
        for(int t=0;t<2;t++) answer[t]=(answer[t]>1)? 7-answer[t]:6;
        
        
        return answer;
    }
}