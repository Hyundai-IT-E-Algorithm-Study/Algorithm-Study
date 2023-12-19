import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //바닥도 넣어줌(N+1개).
        int[] trees = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
        //높이간 간격 넣는 배열
        int[] intervals = new int[N];
        for(int i=N-1; i>=0; i--){
            intervals[N-1-i]=trees[i+1]-trees[i];
        }


        //자르는 나무의 개수
        int n = 0;
        //잘린 나무 길이 합(long으로 안하면 틀림..)
        long sum = 0;
        //자르는 높이
        int height = trees[N];//최대 나무 높이로 초기화
        for(int i=0; i<N; i++){
            //자르는 나무 개수 점점 증가
            n++;
            //해당 구간을 전부 자르면 자르는 나무 길이가 M보다 커질때
            if (M < sum + (long)n*intervals[i]){
                //특정 정수 높이에서 잘랐을 때, 자르는 나무길이가 정확히 M이라면
                if ((M-sum)%n == 0) System.out.println(height-((M-sum)/n));
                //정확히 M이 아니라면
                else System.out.println(height-((M-sum)/n)-1);
                //출력 후 종료
                System.exit(0);
            }
            //조건문에 안걸린다면 해당 구간을 모두 잘라도 됨.
            sum += (long)n*intervals[i];
            height -= intervals[i];
        }
        //자르는 나무의 개수가 M보다 큰 경우가 없으면 모든 나무를 자르는 경우
        System.out.println(0);
    }
}
