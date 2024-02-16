for w in range(1, 11):
    a = int(input())
    arr = list(map(int, input().split()))

    sum = 0
    for i in range(2, a - 2):
        if arr[i - 1] < arr[i] > arr[i + 1]:
            if arr[i - 2] < arr[i] > arr[i + 2]:
                sum = sum + arr[i] - max(arr[i - 2], arr[i - 1], arr[i + 1], arr[i + 2])

    print(f'#{w} {sum}')