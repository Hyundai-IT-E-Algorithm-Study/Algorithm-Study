class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
            
        for (int i = 3; i <= sum; i++) {
            int w = i;
            int h = sum / i;
            
            if(w > h) continue;
            
            if (yellow == (w - 2) * (h - 2)) {
                answer[0] = h; 
                answer[1] = w;
                break;
            }
        }
        
        return answer;
    }
}
