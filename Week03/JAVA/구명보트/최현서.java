//"2명"을 고르는 것이기에,
//최대한 짝을 많이 구하는것이 중요하고,
//따라서 남은 인원 중 가장 무거운 인원과 가장 가벼운 인원을 
//최대한 같은 보트에 구조하면, 그게 보트의 최소값
//즉, 그리디로 풀 수 있는 문제!!

//배에 탑승가능인원이 3명 이상이었으면, 그리디만 적용해서 풀긴 어려웠을것..

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
    	int thinIdx = 0;
    	int boatNum = 0;
    	Arrays.sort(people);
    	if(people.length == 1) return 1;
    	int saveCnt =0;
			
			//두 인덱스가 만나고 엇갈릴때까지 반복 > 모든 인원 구조될 때까지 반복
    	for (int heavyIdx=people.length-1;heavyIdx>=thinIdx ;heavyIdx--) {
					//보트 하나 추가
    			boatNum++;
					//안탄 인원 중 제일 무거운 인원 먼저 구조됨.
    			saveCnt++;
					//넣고 난 후 모든 인원을 다 구조했으면, break
					//(saveCnt변수와 이 조건 없어도 됨.. 보트수엔 영향을 안 주기 때문)
					if(saveCnt == people.length) break;
					//만약 안탄 인원 중 제일 가벼운 인원 넣었을때 초과 안하면,
    			if (people[heavyIdx]+people[thinIdx] <= limit) {
						//제일 가벼운 인원 구조됨
    				saveCnt++;
						thinIdx++;
    			 }
    	}
    	
        return boatNum;
    }
}
