import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();

        int[] block= new int[W];

        for (int i=0; i<W; i++){
            block[i] = sc.nextInt();
        }

        int[] DP = new int[W];
        //최대값(500)으로 DP 초기화
        Arrays.fill(DP, 500);

        //정방향으로 DP넣기
        int barrier = 0;
        for (int i=0; i<W; i++){
            //barrier 보다 크거나같은게 있으면 barrier변경
            if (block[i]>=barrier){
                DP[i]=0;
                barrier = block[i];
            }
            //barrier보다 작으면 물이 고임: DP에 저장
            else DP[i] = barrier - block[i];
        }

        //역방향으로 DP넣기
        barrier = 0;
        for (int i=W-1; i>=0; i--){
            //barrier 보다 크거나같은게 있으면 barrier변경
            if (block[i]>=barrier){
                DP[i]=0;
                barrier = block[i];
            }
            //barrier보다 작으면 물이 고임: DP에 저장
            else {
                if (DP[i] > barrier - block[i]) DP[i] = barrier - block[i];
            }
        }
        int answer = 0;
        for (int water: DP) answer+=water;
        System.out.println(answer);
    }
}
