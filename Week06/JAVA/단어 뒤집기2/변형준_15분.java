import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        String str = br.readLine();
        boolean isTag = false;
        Deque<Character> dq = new ArrayDeque<>();

        for(char c : str.toCharArray()){
            if(c == '<'){
                isTag = true;
                while(!dq.isEmpty()){
                    sb.append(dq.pollLast());
                }
                sb.append(c);
            } else if(c == '>'){
                isTag = false;
                sb.append(c);
            } else if(c == ' '){
                if(!isTag){
                    while(!dq.isEmpty()){
                        sb.append(dq.pollLast());
                    }
                }
                sb.append(c);
            } else {
                if(!isTag){
                    dq.add(c);
                } else {
                    sb.append(c);
                }
            }
        }
        while(!dq.isEmpty()){
            sb.append(dq.pollLast());
        }
        System.out.println(sb);

    }
}
