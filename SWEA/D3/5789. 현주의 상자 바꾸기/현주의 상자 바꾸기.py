T = int(input())
for t in range(1,T+1):
    N, Q = map(int,input().split())
    arr = [list(map(int,input().split())) for _ in range(Q)]
    bucket = [0]*N
    cnt = 0
    for i in arr:
        cnt +=1
        for j in range(i[0]-1,i[1]):
            bucket[j] = cnt

    print(f'#{t}', *bucket)