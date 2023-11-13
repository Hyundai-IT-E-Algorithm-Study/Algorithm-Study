import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1,2,3,4,5}; // 5개씩 반복
        int[] b = {2,1,2,3,2,4,2,5}; // 8개씩 반복
        int[] c = {3,3,1,1,2,2,4,4,5,5}; // 10개씩 반복
        int[] score = {0,0,0}; // a,b,c 각각의 맞은 개수
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == a[i%5]) score[0]++;
            if(answers[i] == b[i%8]) score[1]++;
            if(answers[i] == c[i%10]) score[2]++;
        }
        
        // 가장 많이 맞힌 개수
        int max = Math.max(score[0],Math.max(score[1],score[2]));
        
        // 가장 높은 점수를 받은 사람 리스트에 추가하기
        List<Integer> list = new ArrayList<>();
        for(int k=0; k<3; k++){
            if(max == score[k]) list.add(k+1);
        }
        
        // 리스트를 배열로 변환 -- 아이디어 찾아봄
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i); // 리스트 값 하나씩 가져와서 answer 배열에 리턴하는 과정
        }
        return answer;
    }
}
