# 그리디&DP



# Greedy 란?

- “욕심많은” 이라는 뜻을 가진 알고리즘.
- 매 선택에서 지금 이 순간 당장 최적인 답을 선택하여 적합한 결과를 도출.
    - 최단거리를 사용할 때, 현재의 위치에서 고를 수 있는 경로 중 가장 최적의 경로를 탐색하는 방법.
    - 하지만, 중간에 거쳐가야하는 지점이 있어 경로를 두 파트로 나눠 거리를 탐색한다고 했을 때는 최적해끼리의 합이 답이 될 수 있지만, ‘마시멜로 실험’ 처럼 지금 눈 앞에 있는 마시멜로를 먹는 경우와 기다렸다가 2개를 먹는다라는 경우는 서로 충돌 한다.
- 즉, 항상 최적의 값을 보장하는것이 아니라 최적의 값의 ‘근사한 값’을 목표

# 그리디의 특징

### 탐욕 선택 속성

- 매 순간의 최적해가 문제에 대한 최적해

### 최적 부분 구조

- 한번의 선택이 다음 선택에는 무관한 값
![Untitled](https://github.com/Hyundai-IT-E-Algorithm-Study/Algorithm-Study/assets/99467446/b5045c06-737c-44eb-a3ad-a95687e973ef)



### 100 % 최적해..?

- 를 보장해주지 않는다. 그리디 알고리즘을 사용할 수 있는 조건인 탐욕선택속성, 최적부분구조를 띄는 문제에서만 가능!

# 그리디를 적용하는 방법

### 1. 선택 절차

- 현재 상태에서 최적인 선택을 함. 이 후의 선택에 영향을 주지 않음

### 2. 적절성 검사

- 선택한 항목이 문제의 조건을 만족하는지 확인

### 3. 해답 검사

- 모든 선택이 완료 된 후 최종 선택이 문제의 조건을 만족하는지 확인

### 그리디를 사용할 수 있는 문제

- 거스름돈 문제
    - 거스름돈 문제에서 가장 가치가 큰 동전부터 선택
- 섬 연결하기
    
    [](https://school.programmers.co.kr/learn/courses/30/lessons/42861)
    

---

# D.P Dynamic Programming

- “동적 프로그래밍”. 문제를 해결하려 할 때 작은 문제들을 풀어가며 큰 문제를 해결하는 알고리즘.
- 즉, 하나의 문제를 단 한번만 풀도록 하여, 한번 푼 것을 여러번 푸는 비효율을 개선시키는 방법.
- 주로, 시간 초과가 많이 나는 문제 & 재귀를 사용하는 문제에서 사용해보면 풀리는 경우가 많다.

# DP의 특징

### 중복 부분 문제

- 동일한 작은 문제를 반복적으로 해결해야하는 성질

### 최적 부분 구조

- 큰 문제의 최적해가 '작은 문제의 최적해'를 포함하는 성질

# DP를 적용하는 방법

- Memoization
    - 전에 계산한 값을 저장하여 다시 계산하지 않도록 하여 속도를 빠르게 하는 방법
    - 테이블(주로 행렬, 해시)을 생성해 초기화하여, 초기값을 설정 후 ‘점화식’형태 혹은 재귀 형태로 값끼리 연결해줌.
    - 저장되어 있는 값이라면 결과값을 반환하고, 저장되어 있지 않다면 계산을 수행하여 테이블에 저장
        
        ```jsx
        import java.util.*;
        
        public class MemoizationExample {
            private static Map<Integer, Integer> memo = new HashMap<>();
        
            public static int fibonacci(int n) {
                if (n <= 1) {
                    return n;
                }
        
                if (memo.containsKey(n)) {
                    return memo.get(n);
                }
        
                int result = fibonacci(n - 1) + fibonacci(n - 2);
        
                memo.put(n, result);
        
                return result;
            }
        
            public static void main(String[] args) {
                int n = 10;
        
                System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
            }
        }
        
        ```
        

### DP의 종류

- 탑다운 방식
    - 큰문제를 해결하기 위해 작은 문제를 호출하는 방식
    - 작은 문제의 결과값을 저장해 동일한 계산 x → 시간복잡도 감소
    - 재귀 호출
    - 스택 오버플로우 발생 가능성 존재
    
    ```jsx
    public class TopDownDP {
        static int[] dp = new int[100];
    
        public static int fib(int n) {
            if (n <= 1) {
                return n;
            }
            if (dp[n] != 0) { // 메모이제이션
                return dp[n];
            }
            dp[n] = fib(n - 1) + fib(n - 2);
            return dp[n];
        }
    
        public static void main(String[] args) {
            int n = 10;
            System.out.println("fibonacci(" + n + ") = " + fib(n));
        
    ```
    
- 바텀업 방식
    - 작은 문제를 차례대로 해결해 나가는 방식
    - 부분 문제의 해를 저장해 다음 문제를 해결 → 시간복잡도 감소
    - 반복문 형태
    - 초기값 설정, 결과값을 임시로 저장해둘 공간 필요
    
    ```jsx
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
    
    ```
    

### DP를 사용하는 문제

- 피보나치 수열
- 멀리뛰기
    - [https://school.programmers.co.kr/learn/courses/30/lessons/12914](https://school.programmers.co.kr/learn/courses/30/lessons/12914)

---

# Greedy vs. DP

| 분류 | 그리디 알고리즘 | 동적 계획법 |
| --- | --- | --- |
| 설명 | 그리디 알고리즘은 각 단계에서 최적의 선택을 하는 방식으로 문제를 해결하는 방식 | 동적 계획법은 작은 문제의 해를 메모이제이션하여 중복 계산을 피하고, 이를 이용하여 큰문제를 해결하는 방식 |
| 성립조건 | 탐욕 선택 속성 / 최적 부분 구조 | 중복 부분 문제 / 최적 부분 구조 |
| 가장 큰 차이 | 작은 문제에 대한 답이 다음 문제의 답에 영향을 주지 않음 | 작은 문제에 대한 답이 다음 문제의 답에 영향을 줌 |
| 상황 | 모든 상황을 계산하여 최적의 경로를 구할 수 있음
- 모든 상황을 계산하여 시간이 오래 걸림 | 각 단계의 상황에서 선택하여 최적의 경로를 구함
- 최적이 아닌 경우가 될 수 있거나 풀리지 않는 문제가 될 수 있음 |
