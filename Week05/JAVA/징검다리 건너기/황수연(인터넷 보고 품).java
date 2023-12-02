// 이분탐색
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        // 징검다리를 건너는 친구 최소 수
        int min = 1; 
        // 징검다리를 건너는 친구 최대 수
        int max = 200000000;
        
        // 이분탐색 할 기준 : 징검다리 건널 수 있는 친구 수
        while (min <= max) {
          	// 징검다리를 건널 친구 수
            int mid = (min + max) / 2;
            
            // 징검다리 건널 수 있는지 확인
            if (across(stones, k, mid)) {
              	// 다리를 건널 수 있으면 친구 수를 넓힘
                min = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                // 다리를 건널 수 없으면 친구 수를 좁힘
                max = mid - 1;
            }
        }
        
        return answer;
    }
    
    boolean across(int[] stones, int k, int friends) {
        // 못 건너는 징검다리의 개수를 저장
      	int not = 0;
        
        for (int stone : stones) {
            // 디딤돌의 개별 숫자가 건너는 친구 수가 0보다 작으면 건널 수 없음
            if (stone - friends < 0) {
                not++;
            } else {
                not = 0;
            }
              	
            // 못 건너는 징검다리의 수가 k를 넘으면 건널 수 없음
            if (not >= k)
                return false;
        }
        
        return true;
    }
}
