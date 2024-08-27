from heapq import heappop,heappush
import sys
input = sys.stdin.readline

def push_num(num,cnt):
    global mid
    if num <mid:
        heappush(min_heap,-num)
        if cnt%2 == 0:
            heappush(max_heap,mid)
            mid = -heappop(min_heap)
    else:
        heappush(max_heap,num)
        if i%2 == 1:
            heappush(min_heap,-mid)
            mid = heappop(max_heap)

N = int(input())
min_heap = []
max_heap = []
mid = int(input())
print(mid)

for i in range(2,N+1):
    push_num(int(input()),i)
    print(mid)