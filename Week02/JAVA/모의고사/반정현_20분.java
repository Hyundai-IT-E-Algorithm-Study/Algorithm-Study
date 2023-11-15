import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] second={1,3,4,5};
        int[] third={3,1,2,4,5};
        int[] result=new int[3];
        for(int i=0;i<answers.length;i++){
            if(answers[i]==(i%5)+1) result[0]+=1;
            if(i%2==0){
                if(answers[i]==2) result[1]+=1;
            } else{
                if(answers[i]==second[((i-1)/2)%4]) result[1]+=1;
            }
            
            if(answers[i]==third[(i/2)%5]) result[2]+=1;
        }
        
        int mx=0;
        for (int j=0;j<3;j++){
            if (result[j]>mx) {
                mx=result[j];
                answer=new ArrayList<>();
                answer.add(j+1);
            } else if (result[j]==mx){
                answer.add(j+1);
            }
            
        }
        int new_answer[]=new int[answer.size()];
        for(int n=0;n<answer.size();n++){
            new_answer[n]=answer.get(n);
        }
        return new_answer;
    }
}
