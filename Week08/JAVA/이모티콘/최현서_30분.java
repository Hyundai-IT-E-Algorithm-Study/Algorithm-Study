import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();

        //그냥 하나 복사해서 쭉 더해주면 S는 무조건 가능
        int minTime = S;

        //S의 두배보다 많이 가는 경우는 최소값에서 생각할 필요가 없음
        boolean[][] visited = new boolean[2*S+1][2*S+1];
        int[][] time = new int[2*S+1][2*S+1];

        //BFS 시작
        Queue<Integer> emoticonQ = new LinkedList<>();
        Queue<Integer> clipboardQ = new LinkedList<>();
        emoticonQ.offer(1);
        clipboardQ.offer(0);
        visited[1][0] = true;
        time[1][0] = 0;

        while (!emoticonQ.isEmpty()){
            int emoticon = emoticonQ.poll();
            int clipboard = clipboardQ.poll();
            int currTime = time[emoticon][clipboard];
            if (emoticon == S){
                System.out.println(currTime);
                break;
            }

            for (int i=0; i<=2; i++){
                int nextEmoticon = i==1? emoticon : i==2? emoticon+clipboard: emoticon-1;
                int nextClipboard = i==1? emoticon: clipboard;

                if (nextEmoticon<=0 || nextEmoticon>2*S || visited[nextEmoticon][nextClipboard]) continue;
                visited[nextEmoticon][nextClipboard] = true;
                time[nextEmoticon][nextClipboard] = time[emoticon][clipboard]+1;
                emoticonQ.offer(nextEmoticon);
                clipboardQ.offer(nextClipboard);
            }
        }


    }
}
