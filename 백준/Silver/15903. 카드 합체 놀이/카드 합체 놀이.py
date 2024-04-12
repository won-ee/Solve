from heapq import heappush,heappop,heapify

n,m = map(int,input().split())
heap = list(map(int,input().split()))
heapify(heap)

while m:
    a,b=heappop(heap),heappop(heap)
    heappush(heap,a+b)
    heappush(heap,a+b)
    m -= 1

print(sum(heap))
