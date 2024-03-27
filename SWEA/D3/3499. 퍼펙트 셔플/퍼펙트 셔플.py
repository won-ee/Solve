T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    arr = input().split()
    lst = []
    a =0
    if len(arr)%2 == 1:
        for i in range(len(arr)//2+1):
            lst.append(arr[i])
            arr[i] ='_'
            a+=1
    else:
        for i in range(len(arr)//2):
            lst.append(arr[i])
            arr[i] = '_'
            a+=1

    ans = []
    while lst:
        ans.append(lst[0])
        lst.pop(0)
        if len(arr)>a:
            ans.append(arr[a])
            arr.pop(a)

    print(f'#{test_case}',end=' ')
    print(*ans)
