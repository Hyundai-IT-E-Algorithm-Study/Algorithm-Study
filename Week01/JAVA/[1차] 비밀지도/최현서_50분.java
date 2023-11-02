class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
    	String[] answer = new String[n];
        //지도의 한줄씩 암호 해독
    	for (int i=0; i<n; i++) {
            //각 지도의 암호를 이진수로 변환한 String으로 바꾸고(toBinaryString),
            //그걸 Long 자료형으로 바꿈(parseLong)
            //EX) 23 ->  10111(2) -> "10111"  ->  10111
            //    37 -> 100101(2) -> "100101" -> 100101
    		long num1 = Long.parseLong(Integer.toBinaryString(arr1[i]));
    		long num2 = Long.parseLong(Integer.toBinaryString(arr2[i]));
            //Long자료형으로 바꾼 이유는 2진수의 자리수가 길어지면 Int자료형의 범위(최대 2^31-1=2,147,483,647)를 초과하기 때문
            //n이 16이면 16자리수까지 늘어날 수 있으며, 여기에 parseInt를 하면 RuntimeError발생

            // 두 숫자를 더해주고, 
            // %0nd : n자리수 정수형태 String으로 변환(n자리보다 작으면 0으로 채움)
            // 그후 1이나 2는(replaceAll 정규표현식) #으로 0은 공백으로 변환
            // EX) n이 10이라고 가정, 
            //   10111 + 100101 = 110212  ->  "0000110212"   ->   "    ## ###"
    		answer[i] = String.format("%0"+n+"d", num1+num2)
    					.replaceAll("[12]", "#").replace("0", " ");
    	}
        return answer;
    }
}
