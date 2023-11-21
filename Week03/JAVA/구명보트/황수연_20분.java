import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0; // 필요한 구명보트 개수
        Arrays.sort(people); // 몸무게 정렬
        int min_weight = 0; // 최소 몸무게
        
        for(int i = people.length-1; i >= min_weight; i--) { // 최대 몸무게부터 내림차순
            if(people[i] + people[min_weight] <= limit) { // 최대 몸무게 + 최소 몸무게 <= 구명보트 무게 제한
                min_weight++; // 최소 무게 갱신
                answer++;
            } else { // 최대 몸무게 한명만 태우기(최소 몸무게 그대로 남아있음)
                answer++; 
            }
        }
        return answer;
    }
}
