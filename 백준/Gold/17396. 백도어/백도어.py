from heapq import heappop, heappush
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
sight = list(map(int, input().split()))
sight[N-1] = 0
arr = [[] for _ in range(N)]
for _ in range(M):
    st, ed, cnt = map(int, input().split())
    if sight[st] == 1 or sight[ed] == 1:
        continue
    arr[st].append([ed, cnt])
    arr[ed].append([st, cnt])

heap = [(0, 0)]
used = [float("inf")] * N
used[0] = 0
while heap:
    cnt, now = heappop(heap)
    if used[now] < cnt:
        continue
    for next, next_cnt in arr[now]:
        if used[next] > cnt + next_cnt:
            used[next] = cnt + next_cnt
            heappush(heap, (cnt + next_cnt, next))

if used[N-1] == float("inf"):
    print(-1)
else:
    print(used[N-1])
