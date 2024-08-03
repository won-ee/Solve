from collections import  deque

N,M = map(int,input().split())
arr = [0]*101
for i in range(N):
    st,ed = map(int,input().split())
    arr[st] = ed
for i in range(M):
    st,ed = map(int,input().split())
    arr[st] = ed

used = [0]*101
used[1] = 1
q = deque()
q.append((0,1))

while q:
    cnt,now = q.popleft()
    if now == 100:
        print(cnt)
        break
    for i in range(1,7):
        next = now + i
        if next >100 :
            continue
        if arr[next] != 0:
            next = arr[next]
        if used[next] == 1:
            continue
        used[next] = 1
        q.append((cnt+1,next))
