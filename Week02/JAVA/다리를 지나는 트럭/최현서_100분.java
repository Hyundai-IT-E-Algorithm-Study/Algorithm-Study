import java.util.LinkedList;
import java.util.Queue;

class Solution2_1 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	
    	Queue<Integer> trucks = new LinkedList<>(); 
    	
    	for (int truck_weight : truck_weights) {
    		trucks.add(truck_weight);
    	}
    	
    	Queue<Integer> bridge = new LinkedList<>();
    	int time = 0;
    	int sum = 0;
    	
    	while(!trucks.isEmpty()) {
    		if(bridge.size()+1 <= bridge_length) {
	    		if(sum+trucks.peek() <= weight) {
	    			sum+=trucks.peek();
	    			bridge.offer(trucks.poll());
	    			time++;
	    		}
	    		else {
	    			bridge.offer(0);
	    			time++;
	    		}
    		}
    		else {
    			sum-=bridge.peek();
    			bridge.poll();
    		}

    	}
    	
    	
    	
    	return time + bridge_length;
    }	
}
