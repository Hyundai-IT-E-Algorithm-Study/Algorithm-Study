# 🧩(WEEK03) DP/그리디

# DP(Dynamic Programming)

## 개요

### Dynamic Programming(동적계획법)..?

dynamic programming이란 이름엔 별다른 의미가 없고,
기억해 놓은 값을 사용해서 문제를 푸는게 다이나믹 프로그래밍의 전부이다.

### DP의 목적?

메모리를 사용해서(배열 혹은 자료구조를 만든다.) <br/>
중복연산을 줄이고(연산한 결과를 배열에 담는다.), <br/>
수행속도를 개선한다. <br/>

## 개념

## 구현

DP는 구현이 정형화된 알고리즘이 아님. 
*DP유형 만큼은 오래 붙잡고 있기 보다는 오래 고민해도 답이 안나오면 풀이 참고해서 직접 구현해보는 것을 추천.. 
다양한 유형의 문제에 좋은 풀이들을 많이 참고하면서 DP식 사고방식을 장착하면 어느순간 눈이 뜨일 것임*

구현방법을 고민할 땐, 어떻게 하면 뒤로 돌아가지 않을 수 있을까 고민: 
= 현재 단계까지의 연산을 또 하지 않으려면 어떤 정보를 어떤 식으로 누적해야하는지 고민
= 어떤 정보를 어떻게 쌓아야 연산 횟수를 가장 줄일 수 있을까를 고민
= 나만의 자료구조(DP/memorization)를 만들고 거기에 어떤 정보를 담아야 이전 단계로 돌아가지 않을지 고민

구체적 구현방법 나온 사이트..

[알고리즘 - Dynamic Programming(동적 계획법)](https://hongjw1938.tistory.com/47)

## 활용?

특정 유형에만 국한되지 않고, 다양한 유형의 문제를 최적화 할 때 고려될 수 있는 알고리즘.

- 그럼에도, DP를 고려 해야하는 상황?
    1. DFS/BFS로 풀 수는 있지만, 경우의 수가 너무 많은 문제<br/>
    *EX) 정수 삼각형의 높이가 n줄일때, 완전탐색을 하면 최악의 경우엔, 2의 n-1승가지의 경우의 수가 나옴.. 500줄이면 2의 499승..*
    2. 경우의 수들에 중복적인 연산이 많은 문제

<aside>
💡 DP 사용 조건?<br/>
**① Overlapping Subproblems**(겹치는 부분 문제) :

DP는 기본적으로 문제를 나누고 그 문제의 결과 값을 재활용해서 전체 답을 구한다. 그래서 동일한 작은 문제들이 반복하여 나타나는 경우에 사용이 가능하다.

즉, DP는 부분 문제의 결과를 저장하여 재 계산하지 않을 수 있어야 하는데, 해당 부분 문제가 반복적으로 나타나지 않는다면 재사용이 불가능하니 부분 문제가 중복되지 않는 경우에는 사용할 수 없다.

**② Optimal Substructure(최적 부분 구조)

부분 문제의 최적 결과 값을 사용해 전체 문제의 최적 결과를 낼 수 있는 경우**를 의미한다. 부분 문제에서 구한 최적 결과가 전체 문제에서도 동일하게 적용되어 결과가 변하지 않을 때 DP를 사용할 수 있게 된다.

</aside>

## 예제

- 추천문제
    
    
- 예시코드: Memorization을 이용한 피보나치 수열의 구현
    
    ```java
    public class Memoization_Fibonacci {
     
        static long[] memo;
        public static long fibonacci(int n) {
            if (n <= 1)
                return n;
            else if (memo[n] != 0)
                return memo[n];
            else
                return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
     
        }
        
        public static void main(String[] args) {
            memo = new long[101];
            System.out.println(fibonacci(100));
     능
    
    ```java
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.IOException;
    import java.util.StringTokenizer;
    
    public class Main{
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[] coins = new int[n];
            
            // 정렬되어 나타나므로 뒤에서부터 저장한다.
            for(int i=n-1; i >= 0; i--){
                coins[i] = Integer.parseInt(br.readLine());
            }
            
            // 제일 큰 단위의 동전으로 시작하여 값을 메꾼다.
            int ans = 0;
            for(int i=0; i < n; i++){
                // 현재 k가 동전보다 더 크거나 같은 경우에만 현재 동전을 쓸 수 있다.
                if(coins[i] <= k){
                    // 사용된 동전의 수를 추가
                    ans += (k / coins[i]);
                    
                    // 나머지 만큼은 추가 연산해야 하므로 빼준다.
                    k %= coins[i];
                }
                // 0원이 되었다면 그만둔다.
                if(k == 0) break;
            }
            System.out.println(ans);
            br.close();
        }
    }
    ```
