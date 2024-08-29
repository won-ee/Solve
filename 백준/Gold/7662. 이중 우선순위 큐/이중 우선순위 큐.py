from  heapq import heappop,heappush
T = int(input())
for _ in range(T):
    K = int(input())
    max_heap = []
    min_heap = []
    used = [1] * K
    for i in range(K):
        lst = list(input().split())
        if lst[0] == 'I':
            heappush(max_heap,(-int(lst[1]),i))
            heappush(min_heap,(int(lst[1]),i))
        else:
            if len(max_heap)>0 and lst[1] == '1':
                used[heappop(max_heap)[1]] = 0
            elif len(min_heap)>0 and lst[1] == '-1':
                used[heappop(min_heap)[1]] = 0
        while min_heap and used[min_heap[0][1]] == 0:
            heappop(min_heap)
        while max_heap and used[max_heap[0][1]] == 0:
            heappop(max_heap)
    if min_heap == []:
        print('EMPTY')
    else:
        print(-max_heap[0][0],min_heap[0][0])
