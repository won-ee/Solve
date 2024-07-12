from collections import deque
N = int(input())
sty,stx,edy,edx = map(int,input().split())
q = deque()
q.append((sty,stx,0))
ans = -1
used = [[0] * N for _ in range(N)]
move = [(-2,-1),(-2,+1),(0,-2),(0,2),(2,-1),(2,1)]

while q:
    y,x,cnt = q.popleft()
    used[y][x] = 1
    if y == edy and x == edx :
       ans = cnt
       break
    for my,mx in move:
        sy,sx = y+my,x+mx
        if sy<0 or sy>=N or sx<0 or sx>=N:
            continue
        if used[sy][sx] == 1:
            continue
        used[sy][sx] = 1
        q.append((sy,sx,cnt+1))

print(ans)

