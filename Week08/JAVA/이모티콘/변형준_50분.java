import java.io.*;
import java.util.*;

public class Main {
    static class Emoticon {
        int screen, clipboard, time;

        Emoticon(int screen, int clipboard, int time) {
            this.screen = screen; // 화면에 있는 개수
            this.clipboard = clipboard; // 클립보드에 있는 개수
            this.time = time; // 걸린 시간
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[2001][2001];

        //bfs
        Queue<Emoticon> queue = new LinkedList<>();

        queue.add(new Emoticon(1, 0, 0));
        visited[1][0] = true;
        while (!queue.isEmpty()) {
            Emoticon e = queue.poll();

            if (e.screen == S) {
                System.out.println(e.time);
                break;
            }

            //조건에 해당하면 연산 수행 후 큐에 추가
            
            // 화면의 이모티콘을 모두 복사해서 클립보드에 저장
            queue.add(new Emoticon(e.screen, e.screen, e.time + 1));

            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            if (e.clipboard > 0 && e.screen + e.clipboard < 2001 && !visited[e.screen + e.clipboard][e.clipboard]) {
                queue.add(new Emoticon(e.screen + e.clipboard, e.clipboard, e.time + 1));
                visited[e.screen + e.clipboard][e.clipboard] = true;
            }

            // 화면에 있는 이모티콘 중 하나를 삭제
            if (e.screen > 1 && !visited[e.screen - 1][e.clipboard]) {
                queue.add(new Emoticon(e.screen - 1, e.clipboard, e.time + 1));
                visited[e.screen - 1][e.clipboard] = true;
            }
        }
    }
}
