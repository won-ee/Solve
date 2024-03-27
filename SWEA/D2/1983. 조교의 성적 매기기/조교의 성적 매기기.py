T = int(input())
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    lst = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']

    lst2 = []
    for i in lst:
        for j in range(n // 10):
            lst2.append(i)

    aver = []
    for i in range(n):
        a = 0
        for j in range(3):
            if j == 0:
                a += float(arr[i][j] * 0.35)
            elif j == 1:
                a += float(arr[i][j] * 0.45)
            else:
                a += float(arr[i][j] * 0.2)
        aver.append(a)

    score = sorted(aver, reverse=True)
    ranks = []
    for s in aver:
        ranks.append(score.index(s))

    print(f'#{test_case} {lst2[ranks[m - 1]]}')