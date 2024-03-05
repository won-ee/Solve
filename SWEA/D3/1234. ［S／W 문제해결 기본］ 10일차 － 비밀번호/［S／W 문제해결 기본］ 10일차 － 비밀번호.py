for t in range(1,11):
    ar,arr = input().split()
    arr = list(arr)

    while 1:
        for i in range(len(arr)-1):
            if arr[i] == arr[i + 1]:
                arr.pop(i)
                arr.pop(i)
                break
        else:
            break

    print(f'#{t} ',end='')
    for i in arr:
        print(i,end='')
    print()

