import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        boolean tag = false;
        Stack<Character> word = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                tag = true;
                reverse(word);
                System.out.print(s.charAt(i));
            } else if (s.charAt(i) == '>') {
                tag = false;
                System.out.print(s.charAt(i));
            } else if (tag) {
                System.out.print(s.charAt(i));
            } else {
                // 공백을 만나게 되면 reverse(word)를 호출해 이전에 스택에 쌓인 문자들을 거꾸로 출력
                if (s.charAt(i) == ' ') { 
                	reverse(word);
                    System.out.print(" ");
                } else { 
                    // 공백이 나올 때까지 word 스택에 문자를 담는다.
                    word.push(s.charAt(i));
                }
            }
        }
        reverse(word);
    }

    private static void reverse(Stack<Character> word) {
        while (!word.isEmpty()) {
            System.out.print(word.pop());
        }
    }
}
