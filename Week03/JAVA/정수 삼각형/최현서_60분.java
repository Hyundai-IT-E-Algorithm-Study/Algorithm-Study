import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
    	
    	for (int row=1; row<triangle.length; row++) {
    		for(int i=0; i<row+1; i++) {
    			if (i==0) 
    				triangle[row][i] = triangle[row][i] + triangle[row-1][i];
    			else if (i==row)
    				triangle[row][i] = triangle[row][i] + triangle[row-1][i-1];
    			else
    				triangle[row][i] = triangle[row][i] + Math.max(triangle[row-1][i], triangle[row-1][i-1]);
    		}
    	}
    	
    	Arrays.sort(triangle[triangle.length-1]);
        int answer = triangle[triangle.length-1][triangle.length-1];
        return answer;
    }
}
