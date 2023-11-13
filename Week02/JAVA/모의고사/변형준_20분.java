import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        //1번 수포자 1,2,3,4,5,,,              5
        //2번 수포자 2,1,2,3,2,4,2,5,,,,       8
        //3번 수포자 3,3,1,1,2,2,4,4,5,5,,,,, 10   40
        
        int[][] supo = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[][] supoR = new int [3][40];
        for(int i = 0; i < supoR.length; i++){
            for(int j = 0; j < supoR[i].length; j++){
                supoR[i][j] = supo[i][j % supo[i].length];
            }
        }
        int[] scores = {0, 0, 0};
        
        for(int q = 0; q < answers.length; q++){
            if(answers[q] == supoR[0][q % supo[0].length]) scores[0]++;
            if(answers[q] == supoR[1][q % supo[1].length]) scores[1]++;
            if(answers[q] == supoR[2][q % supo[2].length]) scores[2]++;
        }

        int max = 0;
        for(int i = 0; i < 3; i++){
            max = Math.max(scores[i], max);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(scores[i] == max)
                list.add(i + 1);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
