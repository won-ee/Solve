T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    arr = [list(map(int,input().split())) for _ in range(N)]
    used =[0]*N
    MIN = 21e8
    def dfs(level,st):
        global MIN
        if level == N// 2:
           dish1 = dish2 = 0
           for i in range(N):
               for j in range(N):
                   if used[i] == 1 and used[j] == 1:
                       dish1 += arr[i][j]
                   elif used[i] == 0 and used[j] == 0:
                       dish2 += arr[i][j]
           if MIN>abs(dish1-dish2):
               MIN = abs(dish1-dish2)

        for i in range(st,N):
            used[i] = 1
            dfs(level+1,i+1)
            used[i] = 0

    dfs(0,0)
    print(f'#{test_case} {MIN}')