from collections import deque
import copy


def dfs(wall,arr):
    global ans
    if wall == 3:
        ret = virus(arr)

        if ans < ret:
            ans = ret
        return

    for i in range(len(zero)):
        if used[i] == 1:
            return
        used[i] = 1
        backup = copy.deepcopy(arr)
        backup[zero[i][0]][zero[i][1]] = 1
        dfs(wall+1,backup)
        backup[zero[i][0]][zero[i][1]] = 0
        used[i] = 0

def virus(arr2):
    q = deque()
    visit = [[0]*M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if visit[i][j] == 1:
                continue
            if arr2[i][j] == 2:
                q.append((i,j))
                while q:
                    y,x = q.popleft()
                    for k in range(4):
                        dy = diy[k] + y
                        dx = dix[k] + x
                        if dy<0 or dy>=N or dx<0 or dx>=M:
                            continue
                        if arr2[dy][dx] == 1:
                            continue
                        if visit[dy][dx] == 0:
                            if arr2[dy][dx] == 0:
                                visit[dy][dx] = 1
                                arr2[dy][dx] = 2
                                q.append((dy,dx))
    cnt = 0
    for i in range(N):
        for j in range(M):
            if arr2[i][j] == 0:
                cnt += 1
    return cnt

N, M = map(int, input().split())
lst = [list(map(int,input().split())) for _ in range(N)]
zero = []
diy = [0,0,1,-1]
dix = [1,-1,0,0]
ans = 0
for i in range(N):
    for j in range(M):
        if lst[i][j] == 0:
            zero.append((i,j))
used = [0] * len(zero)

dfs(0,lst)
print(ans)