import java.util.*;

class Solution {
    static int wordLen, level, notSame;
    static String start;
    public int solution(String begin, String target, String[] words) {
        wordLen = begin.length();
        //편하게 다루기 위해 리스트로 변환
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        //bfs 시작
        //단어 담기위한 큐
        Queue<String> wordQ = new LinkedList<>();
        //각 단어의 그래프 level 담기위한 큐
        Queue<Integer> levelQ = new LinkedList<>();
        wordQ.offer(begin);
        //최소이므로 한번 나온값은 제거
        wordList.remove(begin);
        //level 0부터 시작
        levelQ.offer(0);
        List<String> removeList = new ArrayList<>();

        while(!wordQ.isEmpty()){
            start = wordQ.poll();
            level = levelQ.poll();

            for (String end : wordList){
                if (canChange(start, end)) {
                    //target과 같아지면 현재 level 반환
                    if (end.equals(target)) return level+1;
                    //변환 가능하면, 큐에 넣음
                    wordQ.offer(end);
                    levelQ.offer(level+1);
                    //삭제할 List에 넣음
                    removeList.add(end);
                }
            }
            //각각 다 삭제함: 어차피 최소기 때문에 언급된 단어는 불필요
            for (String word : removeList){
                wordList.remove(word);
            }
            removeList.clear();
        }
        //bfs가 끝날때까지 target이 안나오면, 0반환
        return 0;
    }
    
    //한글자로 변환 가능한지 여부 확인 함수
    public static boolean canChange(String start, String end) {
        notSame = 0;
        for(int i=0; i<wordLen; i++){
            if (start.charAt(i) != end.charAt(i)) notSame++;
            if (notSame == 2) return false;
        }
        return true;
    }
}
