for w in range(1,11):
    n = int(input())
    arr = list(map(int, input().split()))

    for i in range(n):
        x = arr.index(max(arr))
        y = arr.index(min(arr))
        arr[x] = arr[x] - 1
        arr[y] = arr[y] + 1

    print(f'#{w} {max(arr) - min(arr)}')
