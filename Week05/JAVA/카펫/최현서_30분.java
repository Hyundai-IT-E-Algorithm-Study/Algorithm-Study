class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        //전체 영역의 넓이(칸수)는 두 색의 개수 합과 같다.
        int area = brown + yellow;
        //가로길이는 1~area범위에서 벗어날 수 없으므로
        // 이 범위에서 나머지 조건 완전 탐색
        for(int w=1; w<=area; w++){
            double h=(double)area/w; //세로길이는 넓이에서 가로길이로나눈 것
            if(w >= h){
              if((w-2)*(h-2) == yellow){ //가로,세로에 2씩 빼주고 곱한게 yellow와 같다
                  answer[0] = w;
                  answer[1] = area/w;
                  break;
              }
            }
        }
        return answer;
    }
}
