class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            String str = String.valueOf(s.charAt(i));
            if(cnt < 0){
                return false;
            }
            if(str.equals("(")){
                cnt++;
            } else{
                cnt--;
            }
        }
        if(cnt != 0) return false;
        return answer;
    }
}
