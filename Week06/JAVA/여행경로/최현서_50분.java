import java.util.*;

class Solution {
    static String[] answer = null;
    static int ticketNum, depth;
    static HashMap<String, ArrayList<String>> adjMap = new HashMap<>();
    public static String[] solution(String[][] tickets) {
        ticketNum = tickets.length;
        //인접맵 만들기
        for (String[] ticket : tickets){
            if(!adjMap.containsKey(ticket[0])){
                adjMap.put(ticket[0], new ArrayList<>());
            }
            adjMap.get(ticket[0]).add(ticket[1]);
        }
        //각 value(ArrayList) 정렬하기(알파벳 순서가 가장 빠른게 먼저 출력되도록)
        for (String key : adjMap.keySet()){
            Collections.sort(adjMap.get(key));
        }
        //총 경로는 티켓숫자+1만큼임
        answer = new String[ticketNum+1];
        //시작은 무조건 ICN
        answer[0] = "ICN";
        //깊이 우선 탐색(먼저 나오는 값 출력) 실시
        dfs("ICN");
        return answer;
    }
    public static boolean dfs(String start){
        depth++;
        //answer가 다 채워지면 끝
        if(depth == ticketNum+1) return true;
        //start로부터 더 나아갈 경로가 없다면 재귀차단
        if (!adjMap.containsKey(start)) return false;
        for (int i = 0 ; i< adjMap.get(start).size(); i++){
            if(!adjMap.get(start).get(i).equals("visited")){
                String end = adjMap.get(start).get(i);
                adjMap.get(start).set(i, "visited");
                answer[depth] = end;
                //true가 되는 값이 하나라도 있으면 true 반환하고 종료
                if(dfs(end)) return true;
                //depth는 static이므로 다시 감소
                depth--;
                //visited를 다시 원래값으로 초기화
                adjMap.get(start).set(i, end);
            }
        }
        return false;
    }

}
