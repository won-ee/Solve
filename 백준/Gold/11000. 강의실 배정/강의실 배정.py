from heapq import heappop,heappush
import sys
input = sys.stdin.readline

N = int(input())

time = []
for _ in range(N):
    arr = list(map(int, input().split()))
    time.append(arr)
time.sort()

heap = []
heappush(heap,time[0][1])
for i in range(1,N):
    if time[i][0] < heap[0]:
        heappush(heap,time[i][1])
    else:
        heappop(heap)
        heappush(heap,time[i][1])

print(len(heap))