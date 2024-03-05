for t in range(1, 11):

    def inorder(now):
        if now >= len(lst):
            return
        inorder(now * 2)
        print(lst[now], end='')
        inorder(now * 2 + 1)

    n = int(input())
    arr = [list(input().split()) for _ in range(n)]
    lst = [0] * (n + 1)

    for i in range(n):
        lst[int(arr[i][0])] = arr[i][1]

    print(f'#{t}', end=' ')
    inorder(1)
    print()