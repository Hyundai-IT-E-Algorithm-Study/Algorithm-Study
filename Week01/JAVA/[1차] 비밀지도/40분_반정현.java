package day1;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
    	//[1차] 비밀지도
    	// arr1, arr2는 길이 n인 정수 배열
    	// 지도 두개를 합치는 문제
    	// !!지도의 한 변 크기 역시 n!!
    	
 
        String[] answer = new String[n];
		
        // arr1[i]와 arr2[i]를 이진수로 변환한 문자열의 문자를 각각 비교해서, answer[i] 출력
        // 이때, 동일 위치에 존재하는 문자가 둘 중 하나라도 '1'이면 '#'
        
        // arr1[i], arr2[i] 순회 for문
		for (int i=0;i<n;i++) {
		
			char[] tmp2=new char[2];
			
			// String answer[i](지도의 한 변)에 저장될 n개의 문자 : char 배열(길이 n)에 저장
			char[] result=new char[n];
			
			// arr1[i], arr2[i]를 이진수로 변환하여 문자열 배열에 저장
			String[] tmp3= {Integer.toBinaryString(arr1[i]),Integer.toBinaryString(arr2[i])};
			
			// 만약 arr1[i]를 이진수를 변환한 길이와 arr2[i]를 이진수로 변환한 길이가 다를 때
			// ex) arr1[i]=100(2); 길이 3	arr2[i]=10100(2); 길이 5일 때를 처리하기 위한 tmp
			// '00100'의 경우, 변환한 이진수 값을 실제로 비교하는 index 시작 번호인 2
			int[] tmp= {n-tmp3[0].length(),n-tmp3[1].length()};
		
			//지도 한 변을 완성하기 위한 for문(길이 n)
			for (int j=0;j<n;j++) {
				
				//한 변의 j번째 문자를 채우는데, tmp3[0][j]과 tmp3[1][j]을 직접 비교하지 않고 실질적으로 비교할 값을 tmp2[0], tmp2[1]에 저장하여 비교
				// j<tmp[0] 혹은 j<tmp[1]일 경우 '0', 아니면 tmp3[0].charAt(j-tmp[0])/tmp3[1].charAt(j-tmp[1])
				for(int t=0;t<2;t++) tmp2[t]=j<tmp[t]? '0':tmp3[t].charAt(j-tmp[t]);
				
				//비교 후 j번째 문자 저장
				if (tmp2[0]=='1' || tmp2[1]=='1') result[j]='#';
				else result[j]=' ';
				
			}
			
			// char 배열 result를 문자열로 변환하여 answer[i]에 저장
			answer[i]=new String(result);			
		}
        return answer;
    }
}
