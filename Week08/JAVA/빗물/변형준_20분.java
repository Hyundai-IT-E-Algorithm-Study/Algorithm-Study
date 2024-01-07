import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] blocks = new int[W];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int rain = 0;

        // 블록의 양 끝은 빗물이 고일 수 없다.
        for (int i = 1; i < W - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, blocks[j]); // 현재 위치의 왼쪽 블록 중 가장 높은 블록
            }

            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, blocks[j]); // 현재 위치의 오른쪽 블록 중 가장 높은 블록
            }

            int min = Math.min(left, right);

            if (min > blocks[i]) {
                rain += min - blocks[i]; // 현재 위치의 블록이 최소보다 낮다면 빗물이 고일 수 있다.
            }
        }

        System.out.println(rain);

    }
}
