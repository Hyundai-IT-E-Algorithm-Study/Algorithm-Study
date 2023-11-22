import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
    	int thinIdx = 0;
    	int boatNum = 0;
    	Arrays.sort(people);
    	if(people.length == 1) return 1;
    	int saveCnt =0;
    	for (int fatIdx=people.length-1;fatIdx>=0;fatIdx--) {
    			if(saveCnt == people.length) break;
    			boatNum++;
    			saveCnt++;
    			if(thinIdx < fatIdx) {
    			if (people[fatIdx]+people[thinIdx] <= limit) {
    				thinIdx++;
    				saveCnt++;
    			 }
    			}
    	}
    	
        return boatNum;
    }
}
