import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        //뒤집은 S
        StringBuilder sb = new StringBuilder(S);
        String reverseS = sb.reverse().toString();

        int wordLen = S.length();
        boolean tagMode = false;
        //처음부터 단어가 시작 될 수 있음
        int wordStart = 0;

        for(int i=0; i<wordLen; i++){
            //공백이고, 태그가 아닐때,
            if (S.charAt(i) == ' ' && !tagMode){
                //이전 단어까지 역방향 출력
                for(int r=wordLen-i; r<wordLen-wordStart; r++){
                    System.out.print(reverseS.charAt(r));
                }
                //현재 공백 출력
                System.out.print(' ');
                //새로운 단어의 시작
                wordStart = i+1;
            }
            //tag 시작일때,
            if(S.charAt(i) == '<'){
                //역방향 출력(단어의 끝일 수 있음)
                for(int r=wordLen-i; r<wordLen-wordStart; r++){
                    System.out.print(reverseS.charAt(r));
                }
                //태그모드 ON
                tagMode = true;
            }
            //태그 끝일때,
            if(S.charAt(i) == '>'){
                System.out.print('>');
                //태그모드 OFF
                tagMode = false;
                //단어의 시작일 수 있음.
                wordStart= i+1;
            }
            //태그모드일땐, 정방향 출력
            if (tagMode) System.out.print(S.charAt(i));
        }
        //마지막에 남은 단어 있다면 역방향 출력
        for(int r=0; r<wordLen-wordStart; r++){
            System.out.print(reverseS.charAt(r));
        }

    }
}
