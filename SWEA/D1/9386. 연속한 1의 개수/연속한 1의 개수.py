a = int(input())
for w in range(1, a + 1):
    n = int(input())
    ar = int(input())
    arr = list(map(int, str(ar)))

    lst = []
    count = 0
    for i in arr:
        if i == 1:
            count += 1
        elif i == 0:
            lst.append(count)
            count = 0
    if count > 0:
        lst.append(count)

    print(f'#{w} {max(lst)}')