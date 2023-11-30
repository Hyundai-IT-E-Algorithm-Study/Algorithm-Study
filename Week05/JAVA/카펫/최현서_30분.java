class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        //전체 영역의 넓이(칸수)는 두 색의 칸수 합과 같다.
        int area = brown + yellow;
        // 가로(세로)길이는 3(yellow가 1이상이므로)~area범위에서 벗어날 수 없으므로
        // 이 범위에서 나머지 조건 완전 탐색(완전탐색 구현을 선택했다면, 문제를 잘 읽고.. 완전 탐색 범위를 가능한 좁혀야 한다..)
        for(int w=3; w<area; w++){
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
