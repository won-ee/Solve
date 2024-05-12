N = int(input())
K = int(input())
arr = list(map(int,input().split()))
arr =list(set(arr))
arr.sort()

if N<K:
    print(0)
else:
    lst = []
    for i in range(len(arr)-1):
        ar = abs(arr[i]-arr[i+1])
        lst.append(ar)

    lst.sort()
    for _ in range(K-1):
        lst.pop()
    print(sum(lst))