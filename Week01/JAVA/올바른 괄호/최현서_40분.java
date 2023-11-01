import java.util.ArrayList;

class Solution {
    boolean solution(String s) {
        
    	boolean answer = true;
        ArrayList<String> ptStack = new ArrayList<>();
        int len=s.length();
        //문자열 맨뒤에서부터 첫글자까지 탐색
        for (int i=len-1; i>=0; i--) {
        	//마지막 글자가 닫히는 괄호이면 제거하고 반환값을 스택에 넣음
        	if(s.charAt(i) == ')') 
        		ptStack.add(s.substring(i,i+1));
        	
        	//마지막 글자가 열리는 괄호이면 가장 최근에 스택에 들어온 닫히는 괄호 삭제
        	if(s.charAt(i) == '(') {
        		try {
        			ptStack.remove(ptStack.size()-1);
				} catch (Exception e) {
					//만약 스택이 비어있다면 열리는 괄호에 대한 닫히는 괄호가 없다는 뜻이므로 
					//바로 false로 정답반환
					answer = false;
					break;
				}
        	}
        }
        
        //answer가 false이면 : 열리는 괄호에 대한 닫히는 괄호(뒤)가 없다는 뜻 -> false 반환
        //만약 스택이 다 지워지지 않았다면 : 닫히는 괄호에 대한 열리는 괄호(앞)가 없다는 뜻 -> false 반환
        //스택이 비어있다면 : 모든 괄호가 앞뒤로 열리고 닫히게 짝을 잘 지었다 -> true 반환
        return answer? ptStack.isEmpty() : answer;
    }
}
