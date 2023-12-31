DFS ( 그래프의 깊이 우선 탐색 )
=============
<br/> 

## 1. 도입

<br/> 

> 현재 정점과 인접한 간선들을 하나씩 검사하다가, 아직 방문하지 않은 정점으로 향하는 간선이 있다면 그 간선을 따라가 그래프의 모든 정점을 발견하는 방법

<br/> <br/> <br/> 
   
### 특성
<br/>
> 1. 더 따라갈 간선이 없으 경우 이전으로 돌아감

<br/>
<br/>

> 2. 인접 리스트일 경우 시간복잡도 O(│V│+│E│)

      방향 그래프는 모든 간선을 1번, 무방향 그래프는 2번 방문 

<br/>

> 3. 인접 행렬일 경우 시간복잡도 O(│V│<sup> 2</sup> )

</br> 

### 예제

<br/>

 1. 두 정점이 서로 연결되어 있는가 확인하기
   
<br/>

 2. 연결된 부분집합의 개수 세기

      주어진 그래프가 몇개의 컴포넌트로 구성되어 있는가
   
<br/>

**3. 위상정렬 : 의존성 그래프**

      DAG의 정점을 배열하는 문제

* DAG : 사이클 없는 방향 그래프
      작업 B를 하기 전에 반드시 작업 A를 해야함 : 작업 B가 작업 A에 의존
  
<br/>

* 위상정렬 방법
  
      들어오는 간선이 하나도 없는 정점들을 하나씩 찾아서 정렬 결과의 뒤에 붙이고, 그래프에서 이 정점을 지우는 과정을 반복

* 위상정렬 방법 : dfs
  
      dfsAll()을 수행하며 dfs()가 종료할 때마다 현재 정점의 번호를 기록
      dfsAll()이 종료한 뒤 기록한 순서를 뒤집으면 위상 정렬 결과
  


<br/> <br/> <br/> 
BFS ( 그래프의 너비 우선 탐색 )
=============
<br/> 

## 1. 도입

<br/> 

> 시작점에 가까운 정점부터 순서대로 방문하는 탐색 알고리즘

<br/> <br/> <br/> 
   
### 특성
<br/>
> 1. 각 정점을 방문할 때마다 모든 인접 정점 검사
> 2. 이 중 처음보는 정점을 발견하면 방문 예정 목록에 저장
> 3. 인접한 정점 모두 검사 후, 저장 목록에서 다음 정점을 꺼내 방문
> 4. 시작점에 가까운 정점부터 순서대로 방문 : 선입선출 큐

<br/>
<br/>

> 2. 인접 리스트일 경우 시간복잡도 O(│V│+│E│)

      방향 그래프는 모든 간선을 1번, 무방향 그래프는 2번 방문 

<br/>

> 3. 인접 행렬일 경우 시간복잡도 O(│V│<sup> 2</sup> )

</br> 

### 예제

<br/>

 1. 최단 경로 찾기
   
<br/>
