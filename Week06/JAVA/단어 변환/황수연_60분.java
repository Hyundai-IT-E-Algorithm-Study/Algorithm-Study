class Solution {
	static boolean[] visited;
	static int answer = 0;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length]; // 방문 여부 체크 초기화

		dfs(begin, target, words, 0);
		return answer;
	}

	public static void dfs(String begin, String target, String[] words, int cnt) {
		if (begin.equals(target)) { // begin이 target과 같아지면
			answer = cnt;
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (visited[i]) continue; // 이미 방문한 words면 통과
            
      // 겹치는 철자 세기
			int same = 0;
			for (int j = 0; j < begin.length(); j++) {
				if (begin.charAt(j) == words[i].charAt(j)) { 
					same++;
				}
			}

			if (same == begin.length() - 1) { // 한 글자 빼고 모두 같은 경우(hit, hot 같은 경우)
				visited[i] = true;
				dfs(words[i], target, words, cnt + 1); // 재귀 for 다음 변환
        visited[i] = false; // 다음 변환을 위해 방문 초기화 해주기(아이디어 찾아봄)
			}
		}
	}

}
