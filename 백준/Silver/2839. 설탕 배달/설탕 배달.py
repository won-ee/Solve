N = int(input())
for cnt_5 in range(N//5,-1,-1):
    cnt_3 =(N-cnt_5*5)//3
    if cnt_5*5 + cnt_3*3 == N:
        print(cnt_5+cnt_3)
        break
else:
    print(-1)