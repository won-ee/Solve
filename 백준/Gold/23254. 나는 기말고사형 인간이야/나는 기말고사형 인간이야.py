from heapq import heappop, heappush

N, M = map(int, input().split())
N *= 24
score = list(map(int, input().split()))
plus = list(map(int, input().split()))
heap = []

for i in range(M):
    heappush(heap, (-plus[i], score[i]))

while heap[0][0] != 0 and N > 0:
    now_plus, now_score = heappop(heap)
    now_plus *= -1

    time = (100 - now_score) // now_plus
    if N >= time:
        N -= time
    else:
        time = N
        N = 0

    next_score = time * now_plus + now_score
    next_plus = 100 - next_score

    heappush(heap, (-next_plus, next_score))

ans = 0
for i in heap:
    ans += i[1]

print(ans)
