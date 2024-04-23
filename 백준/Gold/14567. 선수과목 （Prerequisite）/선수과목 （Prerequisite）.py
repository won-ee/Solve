from collections import deque

N,M = map(int,input().split())
arr = [[] for _ in range(N+1)]
acc = [0]*(N+1)
for _ in range(M):
    a,b = map(int,input().split())
    arr[a].append(b)
    acc[b] += 1

ans = [0] * (N+1)
ret = []
q = deque()

for i in range(1, N+1):
    if acc[i] == 0 :
        q.append(i)
        ans[i] += 1


for i in range(1,N+1):
    now = q.popleft()
    ret.append(now)

    for next in arr[now]:
        acc[next] -= 1
        if acc[next] == 0:
            q.append(next)
        ans[next] = ans[now] + 1


print(*ans[1:])
