T = int(input())
for t in range(1,T+1):
    N = int(input())
    ABI = [list(map(int,input().split())) for _ in range(N)]
    P = int(input())
    PJ = [int(input()) for _ in range(P)]
    bucket = [0] * 5001

    for i in ABI:
        for j in range(i[0],i[1]+1):
            bucket[j] += 1

    print(f'#{t}', end=' ')
    for i in PJ:
        print(bucket[i],end=' ')
    print()