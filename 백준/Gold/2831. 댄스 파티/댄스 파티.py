N = int(input())
man_arr = list(map(int,input().split()))
woman_arr = list(map(int,input().split()))
min_man = []
max_man = []
min_woman = []
max_woman = []

for i in range(N):
    if man_arr[i] < 0:
        min_man.append(-man_arr[i])
    else:
        max_man.append(man_arr[i])
    if woman_arr[i] <0:
        min_woman.append(-woman_arr[i])
    else:
        max_woman.append(woman_arr[i])

min_man.sort()
max_woman.sort()
ans = 0

while min_man and max_woman:
    man = min_man.pop()
    woman = max_woman.pop()

    if man > woman:
        ans += 1
    else:
        while max_woman:
            woman = max_woman.pop()
            if man > woman:
                ans += 1
                break

max_man.sort()
min_woman.sort()
while max_man and min_woman:
    man = max_man.pop()
    woman = min_woman.pop()

    if man < woman:
        ans += 1
    else:
        while max_man:
            man = max_man.pop()
            if man < woman:
                ans += 1
                break
print(ans)