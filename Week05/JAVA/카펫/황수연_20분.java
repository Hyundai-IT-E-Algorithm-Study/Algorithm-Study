class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow; // 카펫 격자 총 개수
            
        for (int i = 3; i < sum; i++) {
            int width = sum / i; // 가로
            int vertical = i; // 세로
            
            if ((width - 2) * (vertical - 2) == yellow) {
                answer[0] = width; 
                answer[1] = vertical;
                break;
            }
        }
        
        return answer;
    }
}
