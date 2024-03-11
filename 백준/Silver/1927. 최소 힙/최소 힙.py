import heapq,sys
input = sys.stdin.readline
arr = []
N = int(input())
for _ in range(N):
    x = int(input())
    if x != 0:
        heapq.heappush(arr,x)
    else:
        if len(arr) == 0:
            print(0)
        else:
            print(heapq.heappop(arr))
