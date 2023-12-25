import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = begin.length();

        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(begin, 0));

        Set<String> visited = new HashSet<>(wordSet);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int count = pair.count;

            for (String w : wordSet) {
                int flag = -1;
                for (int j = 0; j < n; j++) {
                    if (word.charAt(j) != w.charAt(j)) {
                        if (flag == -1) {
                            flag = j;
                        } else {
                            flag = -1;
                            break;
                        }
                    }
                }

                if (flag == -1) {
                    continue;
                }

                if (w.equals(target)) {
                    return count + 1;
                }

                if (visited.contains(w)) {
                    queue.add(new Pair(w, count + 1));
                    visited.remove(w);
                }
            }
        }

        return 0;
    }


    static class Pair {
        String word;
        int count;

        public Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
