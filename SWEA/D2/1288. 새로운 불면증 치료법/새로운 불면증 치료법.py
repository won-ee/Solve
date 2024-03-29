T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    lst =set()
    ans = n

    while 1:
        for i in str(ans):
            lst.add(int(i))
        if len(lst) == 10:
            break
        ans += n

    print(f'#{test_case} {ans}')