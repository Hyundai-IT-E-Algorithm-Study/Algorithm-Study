import java.util.*;

// 정확성 81.5 효율성 18.5
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        // 앞 뒤로 무게의 합을 비교해서 빼기 위해 Deque 사용
        Deque<Integer> dq = new LinkedList<>();
        for(int i = people.length - 1; i >= 0; i--){
            dq.add(people[i]);
        }
        int temp = 0;
        
        while(true){
            if(dq.size() == 1){
                dq.poll();
                answer++;
                break;
            }else{
                // 정렬 시켜놓고 가장 큰 값부터 차례로 구출
                // 가장 큰 값과 작은 값을 더하여 limit 보다 낮거나 같을 때만 작은 값 구출
                temp = dq.pollFirst();
                answer++;
                // 사람의 몸무게는 40kg 이상이기 때문에
                if(limit - temp < 40) continue;
                else {
                    if(limit >= temp + dq.peekLast()){
                        temp = dq.pollLast();
                    }
                    if(dq.isEmpty()) break; 
                }             
            }
        }
        return answer;
    }
}
