for t in range(1, 11):
    n = input()
    arr = [list(map(int, input().split())) for _ in range(100)]
    Max_list = []
    daegak = 0
    rdaegak = 0
    for i in range(100):
        hang = 0
        yeol = 0
        daegak += arr[i][i]
        rdaegak += arr[i][99 - i]
        for j in range(100):
            hang += arr[i][j]
            yeol += arr[j][i]
        Max_list.append(hang)
        Max_list.append(yeol)
    Max_list.append(daegak)
    Max_list.append(rdaegak)

    print(f'#{n} {max(Max_list)}')