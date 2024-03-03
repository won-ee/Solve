T = int(input())
for t in range(1,T+1):
    arr = [list(input()) for _ in range(5)]
    MAX = 0

    for i in arr:
        if len(i) > MAX:
            MAX = len(i)

    print(f'#{t}', end=' ')
    for i in range(MAX):
        for j in range(5):
            if len(arr[j]) < MAX:
                arr[j].append('_')
            if arr[j][i] != '_':
                print(arr[j][i], end='')
    print()