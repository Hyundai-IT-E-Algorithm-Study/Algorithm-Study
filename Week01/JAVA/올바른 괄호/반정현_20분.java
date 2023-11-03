package day1;

import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
    	// 올바른 괄호문제(전에 푼 적 있음)
    	
        boolean answer = true;
        Stack<Character> stack_bracket=new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			// '('면 스택에 push
			if(s.charAt(i)=='('){
				stack_bracket.push(s.charAt(i));
			} 
			else {
				// ')'고 스택이 비어있지 않다면 스택의 가장 최근에 넣은 값을 pop
				if(!stack_bracket.isEmpty()) {
					// 해당 값이 '('이 아니면 틀린 괄호 : false; for문 탈출
					if(stack_bracket.pop()!='(') {
						answer=false;
						break;
					}
					// 스택이 비어있으면 틀린 괄호 : false; for문 탈출
				} else{
					answer=false;
					break;
				}
			}//if문-1 	
			
		}//for문

		// 주어진 괄호를 다 조사하고도 스택이 비어있지 않다면 틀린 괄호
		if(!stack_bracket.isEmpty()) answer=false;

        return answer;
    }
}