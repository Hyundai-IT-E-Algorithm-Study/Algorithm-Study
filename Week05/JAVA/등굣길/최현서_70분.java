class Solution {
    public int solution(int m, int n, int[][] puddles) {

        //최단거리수를 담을 DP
        int[][] DP = new int[n+1][m+1];

        //puddle은 DP에 -1로 담음
        for (int[] puddle : puddles)
            DP[puddle[1]][puddle[0]] = -1;

        //집은 물에 잠기지 않고, 시작점 이다. 무조건 1
        DP[1][1] = 1;
        int M= 1000000007;
        //M이 1000000007인 이유: 소수라 계산결과 영향 안미치면서,
        //int범위 안 벗어나는 최대값
        //이걸 모듈러 연산 분배법칙에 적용하면, 매우 큰 값이 나오는 것 방지 가능
        //모듈러 연산 분배법칙
            //(A+B)%M = ((A%M) + (B%M)) % M
            //(A*B)%M = ((A%M) * (B%M)) % M
            //(A-B)%M = ((A%M) - (B%M)) % M
        //이 문제에선 +의 연속이므로 + 분배법칙 활용

        for (int y=1; y<=n; y++){
            for (int x=1; x<=m; x++){
                //만약 물웅덩이면 갈수없으로 DP 계산 안함
                if (DP[y][x] == -1) continue;
                //(y,x)까지의 최단거리는 왼쪽 최단거리와 위쪽 최단거리를 합한것과 같음
                //만약 둘 중 영역을 벗어나거나, 물웅덩이인건 안 더해줌
                if (1 <= y-1 && DP[y-1][x] != -1)
                    DP[y][x] = ((DP[y][x] % M) + (DP[y-1][x] % M)) % M;
                if (1 <= x-1 && DP[y][x-1] != -1)
                    DP[y][x] = ((DP[y][x] % M) + (DP[y][x-1] % M)) % M;
            }
        }
        return DP[n][m] % M;
    }
}
