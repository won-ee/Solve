N = int(input())
top_list = list(map(int,input().split()))
ans = []
max_top =[]

for i in range(N):
    while max_top:
        if max_top[-1][1] > top_list[i]:
            ans.append(max_top[-1][0] + 1)
            break
        else:
            max_top.pop()
    else:
        ans.append(0)
    max_top.append([i, top_list[i]])
print(*ans)