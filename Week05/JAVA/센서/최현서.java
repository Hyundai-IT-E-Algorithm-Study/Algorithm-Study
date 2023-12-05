        //아이디어: k개의 집중국을 세워서 각 센서와의 거리의 합을 최소화 하려면
        // 1. 오름차순된 센서사이의 간격을 계산했을때, 간격이 큰 곳엔 센서를 두면 영역이 넓어진다..
        // 2. k개를 둬야 하므로, 총 간격 중, k-1개 간격을 제거시켜서, 집중국이 위치할 수 있는 k개의 구간을 만들어야 한다..
        // => 오름차순 된 센서 간 간격을 내림차순했을때, 앞에서 k-1개를 제거한 후 나머지를 합해주면 된다.

        // 예시: (5곳에 집중국을 둬야 한다면..-> 4개의 긴 구간 제거)
        //    a   b        c     d                 e       f                          g  h i   j k       l   m   n  o
        //    ____//////////_____///////////////////_______////////////////////////////___________////////___________
        // 이러면 5구간으로 나뉘고 구간당 하나씩 구간내 아무 위치에나 집중국을 세우면 된다.
        // 문제의 헷갈리는 부분은 "수신가능한 영역" 거리의 최소합 .. 이것의 의미는 ______부분의 합을 구하는 것(겹치는거 계산 안함)

        // 만약 이럴 경우는 어떡하는가?
        //    a   b        c     d                 e       f              g             h  i j   k l       m     n    o
        //    ____//////////_____///////////////////_______///////////////#/////////////______________________________
        // g에 집중국 #을 세우면, #의 영역은 0이다.
        // "따라서 k-1개를 제거하면, 반드시 k개의 영역구간이 생긴다."

        //k-1개 간격을 제거하는 이유는 그것이 최대로 제거할 수 있는 간격이기 떄문이다.
        //"k-1개 보다 큰간격을 더 제거하면 수신이 안되는 센서가 반드시 생긴다."
        //"k-1개 보다 간격을 적게 제거하면 반드시 영역이 늘어난다."

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 결론은 집중국 개수만큼의 구간의 합이 최소가 되도록 하면 반드시 영역의 최솟값이 나오는 문제.
public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int N = Integer.parseInt(br.readLine());
                int K = Integer.parseInt(br.readLine());

                int[] sensors = new int[N];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i=0; i<N; i++){
                        sensors[i] = Integer.parseInt(st.nextToken());
                }

                //센서 위치 오름차순 정렬
                Arrays.sort(sensors);

                //센서간 간격 구하기
                int[] term = new int[N-1];
                for (int i=0; i<N-1;i++){
                        term[i] = sensors[i+1] - sensors[i];
                }
                //간격 정렬
                Arrays.sort(term);

                //간격 중 큰거 K-1개 제거한 합이 답
                int answer = 0;
                //만약 (N-1)-(K-1)이 0보다 작다면 for문이 안돌아감
                //이러면 자연스럽게 답이 0이됨.
                //앞에서 N<=K일때 0이라고 미리 조건 지정했으면 더 풀이에 맞음.
                for(int i=0; i<(N-1)-(K-1); i++){
                     answer+=term[i];
                }
                System.out.println(answer);

        }

}
