class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];

        for(int i = 0; i < words.length; i++){
            if(target.equals(words[i])){
                int result = dfs(begin, target, words, visited, 0, Integer.MAX_VALUE);
                if(result == Integer.MAX_VALUE) return 0;
                else return result;
            }
        }
        return 0;
    }

    private int dfs(String begin, String target, String[] words, boolean[] visited, int cnt, int answer) {
        if (begin.equals(target)) {  
            return cnt;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && compareChar(begin, words[i]) == 1) {
                visited[i] = true;
                answer = Math.min(answer, dfs(words[i], target, words, visited, cnt + 1, answer));
                visited[i] = false;
            }
        }
        
        return answer;
    }

    private int compareChar(String begin, String word) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
