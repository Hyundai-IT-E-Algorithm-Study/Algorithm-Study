import java.util.ArrayList;
import java.util.Collections;

class Solution {
	static boolean[] visited;
	static ArrayList<String> allRoute = new ArrayList<>();

	public String[] solution(String[][] tickets) {
		String[] answer = {};
		visited = new boolean[tickets.length];

		trip(0, "ICN", "ICN", tickets); // trip 메서드 초기화
        
		Collections.sort(allRoute); // 알파벳 순 정렬
		answer = allRoute.get(0).split(" "); // 문자열 배열로 반환(아이디어 찾아봄)

		return answer;
	}

  // Route는 현재까지의 경로
	public static void trip(int depth, String start, String route, String[][] tickets) {
    // 모든 티켓을 사용해 여행을 마치면 현재까지의 경로인 route를 allRoute 리스트에 추가하고 해당 재귀 호출을 종료
		if (depth == tickets.length) {
			allRoute.add(route);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (start.equals(tickets[i][0]) && !visited[i]) {
				visited[i] = true;
				trip(depth + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
				visited[i] = false;
			}
		}
	}
}
