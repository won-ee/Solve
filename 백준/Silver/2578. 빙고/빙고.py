arr = [list(map(int, input().split())) for _ in range(5)]
lst = []
for _ in range(5):
    lst += list(map(int,input().split()))

bingo=[0]*26
for i in range(5):
    for j in range(5):
        bingo[arr[i][j]] = (i,j)

ans =[[0]*10 for _ in range(4)]
for k in lst:
    i,j = bingo[k]
    ans[0][i] +=1
    ans[1][j] += 1
    ans[2][i-j] += 1
    ans[3][i+j] += 1
    cnt = 0
    for tlst in ans:
        cnt += tlst.count(5)
    if cnt>=3:
        break
print(sum(ans[0]))

