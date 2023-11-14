import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int truck; // 개별 트럭 무게
        int time = 0;
        int sum = 0; // 다리에 올라간 트럭의 무게 합
        
        for(int i=0; i<truck_weights.length; i++) {
            truck = truck_weights[i]; // 개별 트럭 무게 정의
            
            // 큐가 비어있을 때
            if(q.isEmpty()) {
                q.offer(truck);
                sum += truck;
                time++;
            }
            
            // 큐가 비어있지 않을 때 + 큐가 꽉 차있지 않을 때
            else if(q.size() < bridge_length) {
                if(sum + truck <= weight) { // 다리 위의 현재 트럭의 총 무게 + 다음에 올 트럭의 무게 <= 다리가 감당 가능한 무게
                    q.offer(truck);
                    sum += truck;
                    time++;
                } else {
                    q.offer(0); // 앞으로 한칸 밀어내기 용도
                    time++;
                }
            } else { // 큐가 비어있지 않을 때 + 큐가 꽉 차있을 때
                q.poll();
                sum -= truck;
                time++;
                    
                if(sum + truck <= weight) {
                    q.offer(truck);
                    sum += truck;
                    time++;
                } else {
                    q.offer(0);
                    time++;
                }
            }
        }
        return time + bridge_length; // 마지막으로 들어간 트럭이 나오기까지의 시간까지 더해줌
    }
}
