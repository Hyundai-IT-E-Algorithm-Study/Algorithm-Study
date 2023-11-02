class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
    	String[] answer = new String[n];
    	for (int i=0; i<n; i++) {
    		long num1 = Long.parseLong(Integer.toBinaryString(arr1[i]));
    		long num2 = Long.parseLong(Integer.toBinaryString(arr2[i]));
    		answer[i] = String.format("%0"+n+"d", num1+num2)
    					.replaceAll("[12]", "#").replace("0", " ");
    	}
        return answer;
    }
}
