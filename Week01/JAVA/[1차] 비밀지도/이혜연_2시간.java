import java.util.ArrayList;
class Solution {
    static ArrayList<Integer> calculate(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(n>0) {
			result.add(n%2);
			n/=2;
		}
	
		return result;
	}
    
    static void createMap(int[][] list, int[] arr, int n) {
		for(int i=0;i<n;i++) {
			int length = calculate(arr[i]).size();
				int k = 0;
				if(length!=n) {
					for(k=0;k<n-length;k++) {
						list[i][k] = 0;
					}
				}
				for(int j=length-1;j>=0;j--) {
					list[i][k] = calculate(arr[i]).get(j);
					k++;
				}
			
			}
	}
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[][] map = new String[n][n];
        
        int[][] list1 = new int[n][n];
		int[][] list2 = new int[n][n];
		createMap(list1, arr1, n);
		createMap(list2, arr2, n);
		
		char[][] result = new char[n][n];
		String[] answer = new String[n];
		 
		for(int i=0;i<n;i++) {
			answer[i] ="";
			for(int j=0;j<n;j++) {
				if(list1[i][j]==1 || list2[i][j]==1) {
					result[i][j] = '#'; 
				}
				else
					result[i][j] = ' ';
				answer[i] += String.valueOf(result[i][j]);
			}
		}
        
        return answer;
    }
}
