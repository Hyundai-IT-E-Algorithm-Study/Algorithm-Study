import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int solution(String[][] clothes) {
    	String[] kinds = new String[clothes.length];
    	//종류만 kinds에 담음
    	for (int i=0; i<clothes.length; i++) {
    		kinds[i] = clothes[i][1];
    	}
    	//종류를 리스트 변환
    	List<String> kindList = Arrays.asList(kinds);
    	//종류를 set변환
    	HashSet<String> kindSet = new HashSet<String>(kindList);
    	
    	int answer = 1;
    	//(종류별 개수+1)을 곱해서 경우의 수를 구함
    	//예를들어, 상의와 바지의 조합 
    	//상의 경우의수 : (상의안입음, 티셔츠, 후드, 잠바, 맨투맨)
    	//바지 경우의수 : (바지안입음, 반바지, 청바지)
    	//상의+바지 경우의수 : (4+1) * (3+1) 
    	for (String kind : kindSet) {
    		answer *= (Collections.frequency(kindList, kind)+1);
    	}
        //모두 안입는 경우는 뺴줘야하므로, -1
        return answer-1;
    }
}
