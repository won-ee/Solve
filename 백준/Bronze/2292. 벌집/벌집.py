N = int(input())
i = 1
cnt = 0
while 1:
    cnt += 1
    if i >= N:
        break
    i = (cnt * 6) + i
print(cnt)