class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown+yellow;
		int num1,num2;
        
        for(int i=1;i<=total;i++) {
			if((brown+yellow)%i==0) {
				num1 = Math.max(i, (brown+yellow)/i);
				num2 = Math.min(i, (brown+yellow)/i);
				if(num1*2+(num2-2)*2 == brown) {
					answer[0] = num1;
                    answer[1] = num2;
					break;
				}

            }
		}
        return answer;
    }
}
