import java.util.Arrays;

class Solution {
    static int binLevel, level;
    static String binaryString = "";
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i=0; i<numbers.length; i++){
            answer[i] = canBinaryTree(numbers[i]);
        }
        return answer;
    }
    static int canBinaryTree(long number){
        //1일경우만 밑에 log처리가 안되므로 정답인 1반환(이부분 '질문하기'참조)
        if(number==1) return 1;
        //이진수 자리수
        int binDigit = (int)(Math.floor(Math.log10(number) / Math.log10(2))+1);
        //포화이진트리 변환 level
        binLevel = (int)(Math.floor(Math.log10(binDigit) / Math.log10(2))+1);
        //이진수 변환
        binaryString = Long.toBinaryString(number);
        while(binaryString.length() < (int)(Math.pow(2,binLevel)-1)){
            binaryString = "0".concat(binaryString);
        }
        //DFS 수행(root부터)
        level = 1;
        return dfs((int)(Math.pow(2, binLevel-1))-1);
    }

    static int dfs(int parent){
        if(level == binLevel) return 1;
        //두 자식노드 확인(부모가 0인데, 자식이 1이면 0반환)
        int leftChild = parent - (int)(Math.pow(2, binLevel-level-1));
        if(binaryString.charAt(parent)=='0' && binaryString.charAt(leftChild)!='0') return 0;
        int rightChild = parent + (int)(Math.pow(2, binLevel-level-1));
        if(binaryString.charAt(parent)=='0' && binaryString.charAt(rightChild)!='0') return 0;
        level++;
        if(dfs(leftChild)==0) return 0;
        if(dfs(rightChild)==0) return 0;
        level--;
        return 1;
    }
}
