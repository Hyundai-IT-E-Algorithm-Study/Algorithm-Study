class Solution {
    
    static int N;
    static int[] locations;
    static boolean[] isVisited;
    static int cnt = 0;
    
    public int solution(int n) {
        N = n;
        for(int i = 0; i < N; i++){
            locations = new int[N];
            isVisited = new boolean[N];
            backtracking(i, 0);
        }
        return cnt;
    }
    
    public static void backtracking(int loca, int depth){
        locations[depth] = loca;
        isVisited[loca] = true;
        if(depth == N - 1){
            cnt++;
            return;
        }
        for(int i = 0; i < N; i++){
            if(!isVisited[i] && !isLine(i, depth + 1)) {
                backtracking(i, depth + 1);
                isVisited[i] = false;
            }
        }
    }
    
    public static boolean isLine(int x, int index){
        for(int i = 0; i < index; i++){
            if(Math.abs(locations[i] - x) == Math.abs(i - index)){
                return true;
            }
        }
        return false;
    }
}
