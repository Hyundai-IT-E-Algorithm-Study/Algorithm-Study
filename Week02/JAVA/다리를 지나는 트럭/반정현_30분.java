import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cur_weight=0;
        int bridge_size=0;
        int truck_number=truck_weights.length;
        int idx=0;
        Queue<Integer> bridge_truck=new LinkedList<Integer>();
        for(int i=0;i<bridge_length;i++){
            bridge_truck.offer(0);
        }
        while(idx<truck_number){
	        answer++;
            int truck_value=bridge_truck.poll();
            cur_weight-=truck_value;
            if (truck_value!=0) bridge_size--;
	        if (bridge_size<bridge_length){
		        if (cur_weight+truck_weights[idx]<=weight) {
                    cur_weight+=truck_weights[idx];
                    bridge_truck.offer(truck_weights[idx]);
                    idx++;
                    bridge_size++;
                } else bridge_truck.offer(0);
            }
        }
        answer+=(bridge_length);
        return answer;
    }
}
