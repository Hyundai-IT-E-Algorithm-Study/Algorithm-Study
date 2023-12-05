//사람 한명씩 이동하면서 돌의 개수를 감소시키면,
//돌마다 디딜수있는 숫자가 200,000,000이하이므로,
//사람숫자도 200,000,000만큼 올 수있고
//따라서 200,000,000 x 200,000,000 이라는 어마무시한 반복문을 수행하게된다.
//심지어 한명씩 이동하는 접근은 이진탐색 접근이 어렵다.

//즉, 모든 사람을 이동시키는 방식을 택해야한다.
//다만, 그렇게 택했을때도 200,000,000명을 완전탐색하면 말짱도루묵이다.
//따라서, 200,000,000을 이진탐색 수행한다.(훨씬 수행 수가 줄어든다.)
class Solution {
    static int[] stones;
    static int k;
    static int jump;
    public int solution(int[] stonesParam, int kParam) {
        //static 사용
        stones = stonesParam;
        k = kParam;

        //모든 사람의 이동을 이진탐색
        int minNum = 1; //최소 한명은 건넘
        int maxNum = 200000000; //문제에서 준 최대값(돌밟을수있는 최대값>=건널수있는 사람 최대값)
        int peopleNum = (minNum+maxNum)/2;
        while(minNum <= maxNum){
            if (isAllCanCross(peopleNum)) minNum = peopleNum+1;
            else maxNum = peopleNum-1;
            peopleNum = (minNum+maxNum)/2;
        }
        return peopleNum;
    }


    //(함수) 모든 사람이 건널 수 있는지 체크하는 함수
    //"연속적으로" 못밟는 돌의 수가 늘어나면 점프간격도 그 수만큼 늘어남
    //점프간격이 k보다 커지는 순간 모두 못건넌다고 판단.
    boolean isAllCanCross(int peopleNum) {
        jump = 1; //점프간격
        for (int stone: stones){ //첫번째돌부터 모든사람이 밟을 수 있는 돌인가 탐색
            if (stone< peopleNum){ //해당 돌을 모든 사람이 밟을 수 없을때,
                jump ++; //못밟는 사람들이 현재 점프해야 하는 간격 증가
                if (jump > k){ //점프 간격이 k보다 클때,
                    return false; //못건넌다!(함수종료)
                }
            }
            else jump = 1; //해당 돌을 모든 사람이 밟을 수 있을때,
                           //"점프해야하는 간격 초기화"
        }
        return true; //for문 끝까지 수행 -> 모든 사람들이 다 건넜다!
    }

}
