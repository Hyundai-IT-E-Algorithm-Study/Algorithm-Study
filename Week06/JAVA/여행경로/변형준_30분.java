import java.util.*;

class Solution {
    
    static Queue<String> pq = new PriorityQueue<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] visited = new boolean[tickets.length];

        dfs(tickets, visited, "ICN", "ICN", 0);
        
        StringTokenizer st = new StringTokenizer(pq.peek(), ",");
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        
        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        } 
        
        return answer;
    }
    
    public void dfs(String[][] tickets, boolean[] visited, String nowAirport, String path, int cnt){
        if(cnt == tickets.length) {
            pq.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && nowAirport.equals(tickets[i][0])){
                visited[i] = true;
                String nextAirport = tickets[i][1];
                dfs(tickets, visited, nextAirport, path + "," + nextAirport, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
