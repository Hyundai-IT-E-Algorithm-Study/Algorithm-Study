class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n]; 
        
        //한줄씩 진행
        for(int i = 0; i < n; i++){
            //이진수 String으로 변환
            String code1 = sol(arr1[i],n);
            String code2 = sol(arr2[i],n);
            
            String str = "";
            for(int j = 0; j < n; j++){
                if(code1.charAt(j) == '1' || code2.charAt(j) == '1') str += "#";
                else str += " ";
            }
            answer[i] = str;
        } 
        return answer;
    }
    public static String sol(int num, int len){
        String result = "";
        // 이진수 변환
        while(num != 0){
            result = num % 2 + result;
            num /= 2;
        }
        // n 자리만큼 0 채우기
        while(result.length() != len){
            result = "0" + result;
        }
        return result;
    }
}
