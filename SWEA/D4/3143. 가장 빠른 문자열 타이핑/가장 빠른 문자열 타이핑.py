T = int(input())
for t in range(1, T+1):
    aa, a = input().split()
    flag = len(aa)
    i = 0

    while 1:
        if i >= len(aa):
            break
        if aa[i] == a[0]:
            if aa[i:i + len(a)] == a:
                flag -= len(a)
                flag += 1
                i += len(a)
            else:
                i += 1
        else:
            i += 1

    print(f'#{t} {flag}')