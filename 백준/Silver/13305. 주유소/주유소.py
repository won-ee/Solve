n = int(input())
road = list(map(int,input().split()))
oil = list(map(int,input().split()))
min_oil = oil[0]
ans = oil[0] * road[0]

for i in range(1,len(road)):
    if oil[i] < min_oil:
        min_oil = oil[i]
        ans += road[i] * min_oil
    else:
        ans += road[i] * min_oil
print(ans)