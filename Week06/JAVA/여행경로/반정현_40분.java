import java.util.*;

class Solution {
    public List<String> solution(String[][] tickets) {
        Map<String, List<String>> graph = new HashMap<>();

        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0])) {
                graph.put(ticket[0], new ArrayList<>());
            }
            graph.get(ticket[0]).add(ticket[1]);

            if (!graph.containsKey(ticket[1])) {
                graph.put(ticket[1], new ArrayList<>());
            }
        }


        for (List<String> neighbors : graph.values()) {
            Collections.sort(neighbors);
        }

        List<String> answer = new ArrayList<>();
        dfs(graph, "ICN", new HashSet<>(), answer);

        Collections.reverse(answer);
        return answer;
    }

    private void dfs(Map<String, List<String>> graph, String start, Set<String> visited, List<String> answer) {
        if (graph.get(start).isEmpty()) {
            answer.add(start);
            return;
        }

        while (!graph.get(start).isEmpty()) {
            String neighbor = graph.get(start).remove(0);
            dfs(graph, neighbor, visited, answer);
        }

        answer.add(start);
    }
}
