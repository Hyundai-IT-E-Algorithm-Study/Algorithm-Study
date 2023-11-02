class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
    	String[] answer = new String[n];
        //지도 한줄씩 암호 해독
    	for (int i=0; i<n; i++) {
            /*
            암호를 이진수화한 String으로 변환하고(toBinaryString),
            Long 변환(parseLong)
            EX) 23 ->  10111(2) -> "10111"  ->  10111
                37 -> 100101(2) -> "100101" -> 100101
            */
    		long num1 = Long.parseLong(Integer.toBinaryString(arr1[i]));
    		long num2 = Long.parseLong(Integer.toBinaryString(arr2[i]));
            //Long 변환 이유: 2진수 자리수 길어지면 int자료형의 범위(최대 2^31-1=2,147,483,647) 초과
            //n=16이면 16자리 가능, parseInt하면 RuntimeError

            /*
            두 숫자를 더하고, 
            %0nd : n자리수 정수형태 String으로 변환(n자리보다 작으면 0으로 채움)
            그후 1 또는 2는(replaceAll 정규표현식) #, 0은 공백으로 교체
            EX) n이 10이라고 가정, 
              10111 + 100101 = 110212  ->  "0000110212"   ->   "    ## ###"
            */
    		answer[i] = String.format("%0"+n+"d", num1+num2)
    					.replaceAll("[12]", "#").replace("0", " ");
    	}
        return answer;
    }
}
