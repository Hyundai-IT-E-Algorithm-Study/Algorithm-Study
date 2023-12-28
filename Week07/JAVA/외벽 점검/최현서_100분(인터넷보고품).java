//처음엔 각각의 간격을 이용하고, 최대이동거리 긴 사람을 먼저 적용시키는 그리디 접근을 시도했으나 예외사항이 계속 떠오름
//결국 문제범위상 시간복잡도가 완전탐색이 가능해보여서 완전탐색을 할수밖에 없겠다는 생각까진 이르렀으나,,
//어떻게 완전탐색 구현할지는 전혀 감이 안와서 인터넷 해설보고 풀었습니다..
import java.util.ArrayList;
import java.util.List;

class Solution {
    static int distNum;
    static boolean [] visited;
    static int [] output;
    static List<int[]> orderDistList = null;
    static int[] unOrderDist;
    public static int solution(int n, int[] weak, int[] dist) {
        int weakNum = weak.length;
        distNum = dist.length;
        //시계반대방향도 적용시키기 위해서, 선형으로 만들어준다.(마지막껀 안넣음)
        int[] lineWeak = new int[weakNum*2-1];
        for (int i=0; i<weakNum*2-1; i++){
            if (i<weakNum) lineWeak[i] = weak[i];
            else lineWeak[i] = weak[i-weakNum]+n;
        }
        //모든 간격 순서 경우의수(순열) 담은 리스트 만들기
        orderDistList = new ArrayList<>();
        visited=new boolean[distNum];
        output= new int[distNum];
        unOrderDist = dist;
        distPerm(0);

        //최소를 구하는 문제기에 최대값인 distNum보다 1큰값으로 임의로 지정
        int minCnt = distNum+1;

        //시작지점 인덱스
        for (int start=0; start<weakNum; start++){
            //점검하는사람순서 모든 경우의수(순열)중 하나
            for (int[] orderDist : orderDistList){
                //해당 시작점인덱스(start)의 점검지점에서, 마지막 점검지점까지
                //해당 점검자순서의경우의수(orderDist)에서, 점검자가 차례대로 최종 cnt만큼 나와서
                //각자 최대한 점검을 진행하는 본격 점검의 시작!
                int cnt = 1; //투입 점검자수
                int firstPos = start; //현재 점검자의 처음점검지점 인덱스
                for (int i=0; i<weakNum; i++){
                    int nextPos = start+i; //다음 점검지점 인덱스
                    int diff = lineWeak[nextPos]-lineWeak[firstPos]; //현재 점검자의 처음점검지점에서 다음점검지점까지 거리
                    if (diff > orderDist[cnt-1]){ //현재 점검자가 갈수있는 최대거리보다 총 점검지점간간격이 더 길면,
                        firstPos = nextPos; //다음점검지점이 다음 점검자의 시작점검지점이 된다.
                        cnt++; //점검자수 증가
                        if (cnt == distNum+1) break; //총사람수를 초과했다는것은 모든 사람으로도 점검이 불가능하단 것이다.
                    }
                }
                //"해당 시작점/점검자순서경우의수"에 대한 점검이 마쳤으니, 최소점검자수 최신화
                minCnt = Math.min(minCnt, cnt);
            }
        }
        //모든 시작점에 대한 모든 점검하는사람순서의 최소인원 비교를 다 진행하였다.
        if (minCnt<=distNum) return minCnt; //최소인원 리턴
        return -1;//모든 경우에 점검이 불가능하면, -1반환
    }


    static void distPerm(int permCnt){
        if (permCnt == distNum) {
            int[] orderDist = new int[distNum];
            //깊은 복사
            for (int i=0; i<distNum; i++){
                orderDist[i] = output[i];
            }
            orderDistList.add(orderDist);
            return;
        }

        for(int i=0; i<distNum; i++) {
            if(visited[i]) continue;
            output[permCnt] = unOrderDist[i];
            visited[i] = true;
            distPerm(permCnt+1);
            visited[i] = false;
        }
    }
}
