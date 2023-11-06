import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            // 여는 괄호
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            // 닫는 괄호
            if(s.charAt(i) == ')'){
                // 닫는 괄호를 찾았는데, 여는 괄호가 없으면 size=0이라는 말이고
                if(stack.size() == 0){
                    return false;
                } else stack.pop(); // 닫는 괄호를 찾았는데, 여는 괄호가 있어서 size가 0이 아닌 것이므로 짝이 맞으니깐 pop으로 빼냄
            }
        }
        // for문 다 돌려서 짝이 다 맞았으면 size가 0이여야할텐데 그렇지 않으므로 false 
        if(stack.size() != 0) answer = false;
        return answer;
    }
}
