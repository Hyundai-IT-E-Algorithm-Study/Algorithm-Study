import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 위치 순으로 정렬
        Collections.sort(list);

        // 가까이 있는 것끼리 차이 계산
        List<Integer> distance = new ArrayList<>();
        for(int i = 0; i < N - 1; i++) {
            distance.add(list.get(i + 1) - list.get(i));
        }

        // 내림차순 정렬을 하여 거리 차이가 큰 센서가 앞으로 오도록 배치
        // K가 커질 수록 거리 차이가 큰 것부터 제외 -> 최솟값
        // 거리차이가 큰 곳에 집중국을 설치해야 최솟값
        Collections.sort(distance, Collections.reverseOrder());
//        for(int i = 0; i < N - 1; i++){
//            System.out.print(distance.get(i) + " ");
//        }
//        System.out.println("");
        int sum = 0;
        // 따라서 K = 1 인 경우는 list[0] ~ list[N - 1] 까지의 전체 길이이고
        // K 가 증가함에 따라 차이의 최댓값, 즉 distance[0]부터 제외
        for(int i = K - 1; i < N - 1; i++) {
            sum += distance.get(i);
        }

        System.out.println(sum);

    }

}
