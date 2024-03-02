T = int(input())
for t in range(1, T+1):
    N = int(input())
    lst = list(map(int, input().split()))
    ans = 0
    cnt = 1

    for i in range(N - 1):
        if lst[i] < lst[i + 1]:
            cnt += 1
        else:
            if ans < cnt:
                ans = cnt
            cnt = 1
    if cnt > ans:
        ans = cnt

    print(f'#{t} {ans}')