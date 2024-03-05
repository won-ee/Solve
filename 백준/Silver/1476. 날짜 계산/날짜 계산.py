E,S,M = map(int,input().split())
cnt = 1

while 1:
    if (cnt-E)%15 == 0 and (cnt-S)%28 == 0 and (cnt-M)%19 == 0:
        print(cnt)
        break
    else:
        cnt += 1