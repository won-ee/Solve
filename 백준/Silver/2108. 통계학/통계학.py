from collections import Counter
import heapq

N=int(input())
max_heap = []
min_heap = []
lst = []

def heap(num):
    if len(max_heap) == len(min_heap):
        heapq.heappush(max_heap,-num)
    else:
        heapq.heappush(min_heap,num)

    if len(min_heap)>=1:
        if -max_heap[0] > min_heap[0]:
            temp_min = heapq.heappop(min_heap)
            temp_max = heapq.heappop(max_heap)
            heapq.heappush(max_heap, -temp_min)
            heapq.heappush(min_heap, -temp_max)
SUM = 0
for _ in range(N):
    a = int(input())
    SUM += a
    lst.append(a)
    heap(a)
sorted_lst = sorted(lst)
cnt = Counter(sorted_lst).most_common()
if len(cnt)>1 and cnt[0][1] == cnt[1][1]:
    max_cnt = cnt[1][0]
else:
    max_cnt = cnt[0][0]
print(round(SUM/N))
print(-max_heap[0])
print(max_cnt)
print(abs(min(lst)-max(lst)))
