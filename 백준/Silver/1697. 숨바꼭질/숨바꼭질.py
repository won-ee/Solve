from collections import deque
N,M = map(int,input().split())
visited = [0] * (max(N, M)*2+1)
q = deque()
q.append([N,0])
ans = 0
while q:
    subin,cnt = q.popleft()
    if subin > len(visited) - 1 or subin < 0 or visited[subin] == 1:
        continue
    if subin == M:
        print(cnt)
        exit()
    visited[subin] = 1
    q.append([subin+1,cnt+1])
    q.append([subin-1,cnt+1])
    q.append([subin*2,cnt+1])
