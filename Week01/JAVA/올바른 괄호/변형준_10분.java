class Solution {
    boolean solution(String s) {
        int cnt = 0;
        //괄호가 ")" 가 많으면 불가능 
        //cnt로 for문 중 음수 혹은 끝나고 0이 안되면 불가능
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
        else return true;
    }
}
