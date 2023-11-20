import java.util.Stack;

class Solution {
	static int mapSize = 0;
	static int answer;
	
	static Stack<Integer> stackX = new Stack<>(); // x좌표가 같으면 x축방향 공격 가능
	static Stack<Integer> stackY = new Stack<>(); // y좌표가 같으면 y축방향 공격 가능
	static Stack<Integer> stackPlus = new Stack<>(); // x+y값이 같으면 7시방향 대각선으로 공격가능
	static Stack<Integer> stackMinus = new Stack<>(); // x-y값이 같으면 5시방향 대각선으로 공격가능
	
	public int solution(int n) {
	   answer = 0;
	   mapSize = n;
	   makeQueens(1); // x좌표 1부터 시작
	   return answer;
	}


  
	static void makeQueens(int x) {
		if (stackX.size() == mapSize) {  //가지치기 당하지 않고 x=n 까지 무사히 탐색 수행한 stack들에 대해 answer 증가
			answer++;
			return;
		}

    		//if (x>mapSize) return;  x=1부터 n까지 깊이탐색(재귀) 수행(이거 안넣어줘도 정답 지장 없음- 어차피 x>n인 재귀까지 오려면 가지치기 안당해야함)
    
		for (int y=1; y<=mapSize; y++) {
			if(!stackX.contains(x) && !stackY.contains(y) && !stackPlus.contains(x+y) && !stackMinus.contains(x-y)) {
				//현재까지 뽑힌 퀸의 공격범위에 속하지 않는(가지치기 당하지 않는) x,y에 대해서 4가지 스택에 값을 넣어줌
       			        stackX.push(x);
				stackY.push(y);
				stackPlus.push(x+y);
				stackMinus.push(x-y);
				makeQueens(x+1);
        			//재귀를 수행한 후에는 다른 y값에 영향을 미치지 않도록 stack의 마지막을 다시 빼줌
				stackX.pop();
				stackY.pop();
				stackPlus.pop();
				stackMinus.pop();
			}
		}
		
	}
}
