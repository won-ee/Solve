
def abc(level, idx):
    if level == 0:
        return 1
    if idx == 0:
        return 1
    if idx == level:
        return 1

    return abc(level - 1, idx - 1) + abc(level - 1, idx)


T = int(input())
for t in range(1 , T +1):
    N = int(input()) -1

    print(f'#{t}')
    for i in range(N + 1):
        for j in range(i + 1):
            print(abc(i, j), end=' ')
        print()
