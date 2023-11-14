import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<Integer> solution(int[] answers) {
    	int[] correct = {0,0,0};
    	int[] ruleB = {2, 1, 2, 3, 2, 4, 2, 5};
    	int[] ruleC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    	int ans;
    	
    	
    	for (int i=0; i<answers.length ; i++) {
    		ans = answers[i];
    		
    		if (ans == i%5+1) correct[0]++;
    		if (ans == ruleB[i%8]) correct[1]++;
    		if (ans == ruleC[i%10]) correct[2]++;
    	}
    	
    	int maxCorrect = Integer.max(Integer.max(correct[0],correct[1]),correct[2]);
    	
    	
    	List<Integer> answer = new ArrayList<>();
    	
    	for (int i=0;i<3;i++) {
    		if(correct[i]==maxCorrect) {
    			answer.add(i+1);
    		}
    	}
    	
        return answer;
    }
}
