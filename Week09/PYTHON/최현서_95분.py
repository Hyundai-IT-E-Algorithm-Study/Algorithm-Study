'''
3187: 양치기꿍 풀이
'''

'''
BFS를 수행한후, 각각 몇마리 있는지 판단
그 후 조건에 따라 처리
양<=늑대: 늑대만삼
양>늑대: 양만삼
'''
import sys
from collections import deque
input = sys.stdin.readline

R, C = map(int, input().strip().split())
field = []
for _ in range(R):
    field.append(list(input().strip()))

#BFS 준비
dy = [1,-1,0,0]
dx = [0,0,1,-1]

def inField(y,x): return 0<=y<R and 0<=x<C

visited = [[False]*C for _ in range(R)]

wolfNum, lambNum = 0,0
for y in range(R):
    for x in range(C):
        if field[y][x] != '#' and not visited[y][x]:
            wolf = 0
            lamb = 0
            if field[y][x] == 'v': wolf+=1
            elif field[y][x] == 'k': lamb+=1 
            #bfs 시작
            dq = deque([])
            dq.append((y,x))
            visited[y][x] = True
            
            isFense = True
            while dq and isFense:
                currY, currX = dq.popleft()
                for i in range(4):
                    adjY = currY+dy[i]
                    adjX = currX+dx[i]
                    if not inField(adjY,adjX):
                        isFense = False
                        break
                    adj = field[adjY][adjX]
                    if adj == '#' or visited[adjY][adjX]: continue
                    if adj == 'v': wolf+=1
                    elif adj == 'k': lamb+=1
                    dq.append((adjY,adjX))
                    visited[adjY][adjX] = True
            if isFense:
                if wolf >= lamb: wolfNum+=wolf
                else: lambNum+=lamb
print(lambNum, wolfNum)








'''
16935: 배열돌리기 풀이
'''
import sys
input = sys.stdin.readline

N,M,K = map(int, input().strip().split())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().strip().split())))
oper = list(map(int, input().strip().split()))


def operation(o):
    N, M = len(arr), len(arr[0])
    if 3<=o<=4: result =  [[0]*N for _ in range(M)]
    else: result = [[0]*M for _ in range(N)]
    #상하반전
    if o==1:
        for y in range(N):
            result[y] = arr[N-y-1]
    #좌우반전
    elif o==2:
        for y in range(N):
            for x in range(M):
                result[y][x] = arr[y][M-x-1]
    #오른쪽 90도 회전
    elif o==3:
        for y in range(N):
            for x in range(M):
                result[x][N-y-1] = arr[y][x]
    #왼쪽 90도 회전
    elif o==4:
        for y in range(N):
            for x in range(M):
                result[M-x-1][y] = arr[y][x]
    
    #4등분 시계방향
    elif o==5:
        for y in range(N//2):
            for x in range(M//2):
                result[y][x+(M//2)] = arr[y][x]
        for y in range(N//2):
            for x in range(M//2, M):
                result[y+(N//2)][x] = arr[y][x]
        for y in range(N//2, N):
            for x in range(M//2):
                result[y-(N//2)][x] = arr[y][x]
        for y in range(N//2, N):
            for x in range(M//2, M):
                result[y][x-(M//2)] = arr[y][x]
    #4등분 반시계방향
    elif o==6:
        for y in range(N//2):
            for x in range(M//2):
                result[y+(N//2)][x] = arr[y][x]
        for y in range(N//2):
            for x in range(M//2, M):
                result[y][x-(M//2)] = arr[y][x]
        for y in range(N//2, N):
            for x in range(M//2):
                result[y][x+(M//2)] = arr[y][x]
        for y in range(N//2, N):
            for x in range(M//2, M):
                result[y-(N//2)][x] = arr[y][x]
    return result



for i in range(K):
    arr = operation(oper[i])
for y in range(len(arr)):
    for i, n in enumerate(arr[y]):
        if i!=len(arr[y])-1: print(n, end=" ")
        else: print(n, end="")
    print() 
