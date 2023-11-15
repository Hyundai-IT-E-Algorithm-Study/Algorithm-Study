import java.util.*;

class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<Integer>();
        
        int sec = 0;
        int sum = 0;
        for(int i = 0; i < bridge_length; i++) {
            q.add(0); //다리 위 무게 0
        }
        
        for(int tw : truck_weights) {
            while(sum - q.peek() + tw > weight){ // 무게 초과할 때 마다 한칸씩 벌어짐 : 1 초씩 늘어남
                sum -= q.poll();
                q.offer(0);
                sec++;
            }
            sum += tw - q.poll();// 트럭이 앞으로 나갈때마다 1초 늘어남
            q.offer(tw);
            sec++;
        }
        
        sec += bridge_length; // 마지막 트럭이 빠져나가는 시간
        
        return sec;
    }
}
