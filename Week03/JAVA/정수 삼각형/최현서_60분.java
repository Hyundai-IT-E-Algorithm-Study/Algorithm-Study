import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
    	//원래 DP배열을 따로 만들어주는게 정석이지만,
	//이 문제에서는 triangle배열을 그대로 DP로 써도 정답을 맞추는데 영향을 안줘서
	//triangle을 DP로 썼음
    	for (int row=1; row<triangle.length; row++) {
    		for(int i=0; i<row+1; i++) {
    			if (i==0) 
				//맨 왼쪽일땐, 오른쪽 위의 DP값에 현재 값 더해준게 최대 합계
    				triangle[row][i] = triangle[row][i] + triangle[row-1][i];
    			else if (i==row)
				//맨 오른쪽일땐, 왼쪽 위의 DP값에 현재 값 더해준게 최대 합계
    				triangle[row][i] = triangle[row][i] + triangle[row-1][i-1];
    			else
				//사이에 있을 땐, 왼쪽 위 DP값과 오른쪽 위 DP값 중 큰거에 현재 값 더해준게 최대 합계
    				triangle[row][i] = triangle[row][i] + Math.max(triangle[row-1][i], triangle[row-1][i-1]);
    		}
    	}
    	//밑변 DP를 정렬해 주고 맨 뒤의 값을 꺼내면, 그게 최대 합계
    	Arrays.sort(triangle[triangle.length-1]);
        int answer = triangle[triangle.length-1][triangle.length-1];
        return answer;
    }
}
