import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static String[] strTemp;
    static String[] arr;
    static boolean flag;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        strTemp = new String[L];
        arr = new String[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }


    //depth : 문자열 뽑을 차례
    private static void dfs(int startIndex, int depth) {
        if(depth == L) {
            // 한줄씩 출력
            haveMo();
            if(flag) {
                for(String s : strTemp) {
                    sb.append(s);
                }
                sb.append("\n");
            }
            return;
        }else {
            // 순서 있는 조합
            for (int i = startIndex; i < C; i++) {
                strTemp[depth] = arr[i];
                dfs(i + 1, depth + 1);
            }
        }
    }

    private static void haveMo() {
        flag = false;
        int mo = 0;
        int ja = 0;
        for(String str : strTemp) {
            if(str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u")) {
                mo++;
            }else {
                ja++;
            }
            if(mo >= 1 && ja >= 2){
                flag = true;
                return;
            }
        }
        return;
    }
}

