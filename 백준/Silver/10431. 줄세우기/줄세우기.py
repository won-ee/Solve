T = int(input())
for t in range(1,T+1):
    arr = list(map(int,input().split()))
    lst = []
    x = arr.pop(0)
    ans = 0
    while arr:
        for i in range(len(lst)):
            if lst[i]>arr[0]:
                lst.insert(i,arr[0])
                arr.pop(0)
                ans += len(lst)-i-1
                break
        else:
            lst.append(arr[0])
            arr.pop(0)
    print(f'{x} {ans}')
