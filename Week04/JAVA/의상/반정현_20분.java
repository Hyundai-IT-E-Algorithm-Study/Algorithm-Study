import java.util.HashMap;
class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] one : clothes) {
            if (map.containsKey(one[1])) {
            	map.put(one[1], map.get(one[1])+1);
            } else map.put(one[1], 1);
        }

        for (int value : map.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }
}
