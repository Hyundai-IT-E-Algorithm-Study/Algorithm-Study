class Solution {
    
    static int[][] map;
    static boolean[][] isBlocked;
    
    public int solution(int m, int n, int[][] puddles) {
        map = new int[n + 1][m + 1];
        isBlocked = new boolean[n + 1][m + 1];
        
        for(int[] puddle : puddles){
            isBlocked[puddle[1]][puddle[0]] = true;
        }

        return dp(n, m, 1000000007);
    }
    
    public static int dp(int n, int m, int x){
        map[1][1] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(!isBlocked[i][j]){
                    if(map[i - 1][j] > 0) 
                        map[i][j] += map[i - 1][j] % x;
                    if(map[i][j - 1] > 0) 
                        map[i][j] += map[i][j - 1] % x;
                }
            }
        }  
        int answer = map[n][m] % x;
        return answer;
    }
}
