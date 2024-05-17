N,M = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
lst = []
if N<=M:
    print(max(arr))
elif N>1:
    for _ in range(M):
        lst.append(arr.pop())

    while arr:
        lst[lst.index(min(lst))] += arr.pop()
    print(max(lst))
else:
    print(max(arr))


