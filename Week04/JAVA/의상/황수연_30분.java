import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1; // 최소 한 개의 의상은 입기 때문에 1로 초기화
        HashMap<String, Integer> hm = new HashMap<>(); // 해시 테이블 생성
        
        for(int i = 0; i < clothes.length; i++) {
            String c = clothes[i][1]; // 의상 종류(key) 정의
            hm.put(c, hm.getOrDefault(c, 0) + 1); // 카테고리(key)별로 의상(value) 개수 추가해주기
        }
        
        for (int count : hm.values()) {
            answer *= (count + 1); // 각 의상 종류별 의상 개수에 1을 더해서 곱함
        }
        
        return answer - 1; // 아무것도 입지 않은 경우는 제외
    }
}
