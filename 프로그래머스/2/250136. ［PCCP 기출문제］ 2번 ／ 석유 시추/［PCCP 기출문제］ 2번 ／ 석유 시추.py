from collections import deque

def solution(land):
    answer = 0
    n,m = len(land), len(land[0])
    bucket = [0] * m
    diy = [0, 0, 1, -1]
    dix = [1, -1, 0, 0]
    used = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and used[i][j] == 0:
                q = deque()
                q.append((i, j))
                used[i][j] = 1
                cnt = 0
                lst = set()
                while q:
                    y, x = q.popleft()
                    lst.add(x)
                    cnt += 1
                    for k in range(4):
                        dy = diy[k] + y
                        dx = dix[k] + x
                        if dy<0 or dy>=n or dx<0 or dx>=m:
                            continue
                        if land[dy][dx] == 0: 
                            continue
                        if used[dy][dx] == 1:
                            continue
                        used[dy][dx] = 1
                        q.append((dy, dx))
                for l in lst:
                    bucket[l] += cnt
    
    answer = max(bucket)
    return answer