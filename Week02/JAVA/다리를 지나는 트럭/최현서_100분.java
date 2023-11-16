import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	
    	Queue<Integer> trucks = new LinkedList<>(); 
    	
    	for (int truck_weight : truck_weights) {
    		trucks.add(truck_weight);
    	}
    	
    	Queue<Integer> bridge = new LinkedList<>();
    	int time = 0;
    	int sum = 0;

	//모든 트럭이 출발할 때까지 반복
    	while(!trucks.isEmpty()) {
		//추가했을때 다리길이보다 크지 않으면
    		if(bridge.size()+1 <= bridge_length) {
			//트럭이 하나 더 들어갔을때 무게가 초과하지않는지 확인
			//초과하지 않으면 트럭 추가(시간증가)
	    		if(sum+trucks.peek() <= weight) {
	    			sum+=trucks.peek();
	    			bridge.offer(trucks.poll());
	    			time++;
	    		}
			//초과하면 0을 넣어서 트럭을 진행시킴(시간증가)
	    		else {
	    			bridge.offer(0);
	    			time++;
	    		}
    		}
    		else {	//추가했을때 다리길이보다 길면 맨 앞에 있는거 삭제
    			sum-=bridge.peek();
    			bridge.poll();
    		}

    	}
    	
    	
    	
    	return time + bridge_length;
    }	
}
