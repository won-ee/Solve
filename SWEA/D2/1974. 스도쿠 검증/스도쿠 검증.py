T = int(input())
for t in range(1, T + 1):
    arr = [list(map(int, input().split())) for _ in range(9)]
    diy = [0, 1, 2, 0, 1, 2, 0, 1, 2]
    dix = [0, 0, 0, 1, 1, 1, 2, 2, 2]
    flag = 0

    for i in range(9):
        bucket = [0] * 10
        for j in range(9):
            bucket[arr[i][j]] += 1
        if max(bucket) != 1:
            flag += 1

    for i in range(9):
        bucket = [0] * 10
        for j in range(9):
            bucket[arr[j][i]] += 1
        if max(bucket) != 1:
            flag += 1

    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            bucket = [0] * 10
            for k in range(9):
                dy = diy[k] + i
                dx = dix[k] + j
                bucket[arr[dy][dx]] += 1
            if max(bucket) != 1:
                flag += 1

    if flag == 0:
        print(f'#{t} {1}')
    else:
        print(f'#{t} {0}')