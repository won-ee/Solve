T = int(input())
for t in range(1, T + 1):
    N = int(input())
    lst = list(map(int, input().split()))
    arr = []

    for i in range(N):
        arr.append(max(lst))
        lst.remove(max(lst))
        arr.append(min(lst))
        lst.remove(min(lst))
        if len(lst) == 0:
            lst.append(0)
            break

    print(f'#{t}', end=' ')
    print(*arr[:10])