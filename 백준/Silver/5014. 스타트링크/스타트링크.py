from collections import deque

F, S, G, U, D = map(int, input().split())
# F=최대층수 S = 강호위치 G = 갈곳 U = 위로 D = 아래
arr = [0] * (F+1)
arr[S] = 1

flag = -1
q = deque()

q.append((S,0))
while q:
    now,cnt = q.popleft()
    if now == G:
        flag = cnt
        break
    for i in [U,-D]:
        next = now + i
        if 0<next<=F and arr[next] == 0:
            arr[next] = 1
            q.append((next,cnt+1))

if flag>=0:
    print(cnt)
else:
    print('use the stairs')
