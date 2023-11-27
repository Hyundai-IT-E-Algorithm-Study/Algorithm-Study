import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        //의상 종류별로 맵에 카운트
        for(int i = 0; i < clothes.length; i++) {
        	String type = clothes[i][1];
            if(map.containsKey(type)) map.put(type, map.get(type) + 1);
            else map.put(type, 1);
        }
        
        int answer = 1;
	    for(String key : map.keySet()) {
            answer *= map.get(key) + 1;
	    }

        return answer - 1;
    }
}
