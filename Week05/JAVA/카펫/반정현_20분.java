class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int i = 1;

        while (true) {
            if (yellow % i == 0) {
                int x = yellow / i;
                if (brown + yellow == (x + 2) * (i + 2)) {
                    answer[0] = x + 2;
                    answer[1] = i + 2;
                    break;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        return answer;
    }

}
