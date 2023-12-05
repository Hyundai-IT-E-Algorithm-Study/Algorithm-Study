import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n+1][m+1];
		int answer = 0;
		for(int i=0;i<puddles.length;i++) {
			int x = puddles[i][0];
			int y = puddles[i][1];
			arr[x][y] = -1;
		}
		
		arr[1][1] = 1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(i==1 && j==1) continue;
				if(arr[i][j] == -1) continue;
				
          
                if(arr[i-1][j]!=-1){
                    arr[i][j] += arr[i-1][j];
                    arr[i][j] %= 1000000007;

                }
				if(arr[i][j-1]!=-1){
                    arr[i][j] += arr[i][j-1];
                    arr[i][j] %= 1000000007;
                }
                }
				
			}
        
        return arr[n][m];
    }
}
