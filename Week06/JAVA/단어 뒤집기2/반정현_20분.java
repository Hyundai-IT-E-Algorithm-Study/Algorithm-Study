import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String S = reader.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        boolean reverseFlag = true;

        for (char c : S.toCharArray()) {
            if (c == '<' || c == ' ') {
                if (c == '<') {
                    reverseFlag = false;
                }
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(c);
            } else {
                if (!reverseFlag) {
                    result.append(c);
                    if (c == '>') {
                        reverseFlag = true;
                    }
                } else {
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result.toString());
    }
}
