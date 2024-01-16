#같은 울타리 영역 안의 양들의 숫자가 늑대의 숫자보다 더 많을 경우 늑대가 전부 잡아먹힌다
#그 외의 경우는 양이 잡아 먹힌다
#양치기 꿍
#30분
import sys
input=sys.stdin.readline
sys.setrecursionlimit(100000)
R,C=map(int,input().split())
farm=[list(input()) for _ in range(R)]
#울타리를 기준으로, 양과 늑대의 수
visited=[[False]*C for _ in range(R)]

dy=[0,0,1,-1]
dx=[1,-1,0,0]
def dfs(y,x):
    global sheep,wolf
    visited[y][x]=True
    for i in range(4):
        ny,nx=y+dy[i],x+dx[i]
        if ny in range(R) and nx in range(C):
            if not visited[ny][nx]:
                visited[ny][nx]=True
                if farm[ny][nx]!='#':
                    if farm[ny][nx]=='v':
                        wolf+=1
                    elif farm[ny][nx]=='k':
                        sheep+=1
                    dfs(ny,nx)

ans_sheep,ans_wolf=0,0
for i in range(R):
    for j in range(C):
        if not visited[i][j] and farm[i][j]!='#' and farm[i][j]!='.':
            if farm[i][j]=='v':
                sheep,wolf=0,1
            elif farm[i][j]=='k':
                sheep,wolf=1,0
            else:
                sheep, wolf = 0, 0
            dfs(i,j)
            if sheep>wolf:
                ans_sheep+=sheep
            else:
                ans_wolf+=wolf
print(ans_sheep,ans_wolf)

#35분
#배열 돌리기3
#1번 연산 deque에 넣었다 뺀다
from collections import deque
def first(array):
    array=deque(array)
    res=[]
    while array:
        res.append(array.pop())
    return res
#좌우
def second(array):
    N=len(array)
    M=len(array[0])
    res=[[0]*M for _ in range(N)]
    for r in range(N):
        for c in range(M):
            res[r][M-1-c]=array[r][c]
    return res
#+90도 돌린다
def third(array):
    N = len(array)
    M = len(array[0])
    res=[[0]*N for _ in range(M)]
    for r in range(N):
        for c in range(M):
            res[c][N-1-r]=array[r][c]
    return res
#-90도 돌린다
def fourth(array):
    N = len(array)
    M = len(array[0])
    res=[[0]*N for _ in range(M)]
    for r in range(N):
        for c in range(M):
            res[M-1-c][r]=array[r][c]
    return res
#5번
def fifth(array):
    N = len(array)
    M = len(array[0])
    res = [[0] * M for _ in range(N)]
    r=N//2
    c=M//2
    #1번 -> 2번
    for i in range(r):
        for j in range(c):
            res[i][j+c]=array[i][j]

    #2번 -> 3번
    for i in range(r):
        for j in range(c,M):
            res[i+r][j]=array[i][j]

    #3번 -> 4번
    for i in range(r,N):
        for j in range(c,M):
            res[i][j - c] = array[i][j]

    #4번 -> 1번
    for i in range(r,N):
        for j in range(c):
            res[i - r][j] = array[i][j]
    return res
#6번
def sixth(array):
    N = len(array)
    M = len(array[0])
    res = [[0] * M for _ in range(N)]
    r=N//2
    c=M//2
    # 1번 -> 4번
    for i in range(r):
        for j in range(c):
            res[i+r][j] = array[i][j]

    # 2번 -> 1번
    for i in range(r):
        for j in range(c, M):
            res[i][j-c] = array[i][j]

    # 3번 -> 2번
    for i in range(r, N):
        for j in range(c, M):
            res[i-r][j] = array[i][j]

    # 4번 -> 3번
    for i in range(r, N):
        for j in range(c):
            res[i][j+c] = array[i][j]
    return res

N,M,R=map(int,input().split())
array=[list(map(int,input().split())) for _ in range(N)]
operation=list(map(int,input().split()))
for op in operation:
    if op==1:
        array=first(array)
    elif op==2:
        array=second(array)
    elif op==3:
        array=third(array)
    elif op==4:
        array=fourth(array)
    elif op==5:
        array=fifth(array)
    elif op==6:
        array=sixth(array)

for l in array:
    print(*l)


