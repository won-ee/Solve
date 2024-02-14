a = int(input())
for w in range(a):
    b = int(input())
    c = list(map(int, input().split()))
    y = 0
    for i in c:
        if y < i:
            y = i

    arr = [[0 for i in range(b)] for i in range(y)]

    count = 0
    for i in range(y):
        for j in range(b):
            if c[j] >= y - count:
                arr[i][j] = 1
        count += 1

    count3 = 0
    for i in range(y):
        for j in range(b):
            if arr[i][j] == 0:
                arr[i][j] = 1
            else:
                break
    arr2 = []
    for i in arr:
        arr2.append(b - sum(i))

    x = 0
    for i in arr2:
        if x < i:
            x = i

    print(f'#{w + 1} {x}')