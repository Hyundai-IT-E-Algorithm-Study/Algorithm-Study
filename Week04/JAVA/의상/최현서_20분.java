import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
    	List<String> kindList = new ArrayList<>();
    	//종류만 kindList에 담음
    	for (int i=0; i<clothes.length; i++) {
    		kindList.add(clothes[i][1]);
    	}
    	//종류를 set변환
    	HashSet<String> kindSet = new HashSet<String>(kindList);
    	
    	int answer = 1;
    	//(종류별 개수+1)을 곱해서 경우의 수를 구함
    	//예를들어, 상의+하의+겉옷 조합 
    	//상의 경우의 수 : (상의안입음, 티셔츠, 후드, 셔츠, 맨투맨)
    	//하의 경우의 수 : (바지안입음, 반바지, 청바지, 슬랙스)
        //겉옷 경우의 수 : (겉옷안입음, 패딩, 조끼)
    	//상의+바지+겉옷 경우의수 : (4+1) * (3+1) * (2+1)
    	for (String kind : kindSet) {
    		answer *= (Collections.frequency(kindList, kind)+1);
    	}
        //모두 안입는 경우는 뺴줘야하므로, -1
        return answer-1;
    }
}

//HashMap ver.
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
    	HashMap<String, Integer> clothesMap = new HashMap<>();
    	
    	for (String[] c : clothes) {
    		clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 0) + 1);
    	}
    	int answer = 1;
    	for (String key: clothesMap.keySet()) {
    		answer *= (clothesMap.get(key)+1);
    	}
    	return answer-1;
    }
}
