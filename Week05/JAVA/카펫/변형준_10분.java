class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        int w, h;
        for (int i = 3; i <= sum; i++) {
            w = i;
            h = sum / i;
            
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
