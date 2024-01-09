import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

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
        br.close();

        int ans = 0;
        // 최댓값의 인덱스와 그 값을 찾아라!
        int mx = 0;
        int mx_idx = -1;
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] >= mx) {
                mx_idx = i;
                mx = blocks[i];
            }
        }

        // 0부터 mx_idx까지
        int rvalue = blocks[0];
        for (int i = 0; i <= mx_idx; i++) {
            if (rvalue > blocks[i]) {
                ans += (rvalue - blocks[i]);
            } else {
                rvalue = blocks[i];
            }
        }

        // W-1부터 mx_idx까지
        rvalue = blocks[W - 1];
        for (int i = W - 1; i > mx_idx; i--) {
            if (rvalue > blocks[i]) {
                ans += (rvalue - blocks[i]);
            } else {
                rvalue = blocks[i];
            }
        }

        System.out.println(ans);
    }
}
