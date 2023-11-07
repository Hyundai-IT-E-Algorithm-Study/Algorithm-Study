class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]); // 비트연산자 더하기
            answer[i] = answer[i].replace('0', ' ');
            answer[i] = answer[i].replace('1', '#');
            
            // 이진 문자열의 길이가 n보다 짧은 경우, 좌측에 공백 문자(' ')을 추가하여 길이를 n과 동일하게 맞춰줌(이 부분 때문에 계속 틀려서 아이디어 찾아봄)
            while(answer[i].length()<n){ 
                answer[i] = ' ' + answer[i];
            }
        }
        return answer;
    }
}
