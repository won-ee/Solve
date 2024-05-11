R, C, N = map(int, input().split())
arr = [list(input()) for _ in range(R)]
di = [(0, 1), (1, 0), (-1, 0), (0, -1),(0,0)]
ans = []
ans.append(arr)
ans.append([['O']*C for _ in range(R)])
sam = [['O']*C for _ in range(R)]

for i in range(R):
    for j in range(C):
        if arr[i][j] == 'O':
            for k in range(5):
                dy =di[k][0]+i
                dx =di[k][1]+j
                if dy<0 or dy>=R or dx<0 or dx>=C:continue
                sam[dy][dx] = '.'
ans.append(sam)
sa = [['O']*C for _ in range(R)]
for i in range(R):
    for j in range(C):
        if sam[i][j] == 'O':
            for k in range(5):
                dy =di[k][0]+i
                dx =di[k][1]+j
                if dy<0 or dy>=R or dx<0 or dx>=C:continue
                sa[dy][dx] = '.'
ans.append(sa)

if N<=1:
    for i in ans[0]:
        for j in i:
            print(j,end='')
        print()
elif N%2 == 0:
    for i in ans[1]:
        for j in i:
            print(j, end='')
        print()
elif N%4==3:
    for i in ans[2]:
        for j in i:
            print(j, end='')
        print()
elif N%4 == 1:
    for i in ans[3]:
        for j in i:
            print(j, end='')
        print()


