import java.util.*;

class Solution {
    static boolean[] visited;
    static int equal_length(String a, String b) {
		int cnt = 0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)==b.charAt(i))
				cnt++;
		}
		return cnt;
	}
    public int solution(String begin, String target, String[] words) {
        int length = Integer.MIN_VALUE;
		visited = new boolean[words.length];
		Queue<String> q = new LinkedList<String>();
		q.add(begin);
		
		int result = 0;
        
		while(!q.isEmpty()) {			
			begin = q.poll();
						
			if(begin.equals(target)) {
				return result;
			}
			
						int max_index = 0;
			for(int i=0;i<words.length;i++) {
				if(!begin.equals(words[i])) {
					int word_length = equal_length(begin, words[i]);
					length = Math.max(length, word_length);
					if(word_length == length) {
						max_index = i;
					}
				}
				
			}
			
			if(!visited[max_index]) {
				if(begin.length()-1 == equal_length(words[max_index], begin)) {
					q.add(words[max_index]);
					visited[max_index] = true;
					begin = words[max_index];
					result++;
				}	
			}
			
			
		}
		
    	return 0;

		
    }
}
