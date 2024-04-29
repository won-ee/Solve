import sys
input = sys.stdin.readline

n = int(input())
weight = sorted(list(map(int, input().split())), reverse=True)
m = int(input())
box = sorted(list(map(int, input().split())), reverse=True)
time = 0
if max(box) > max(weight):
    print(-1)
else:
    while len(box) > 0:
        time += 1
        for i in range(len(weight)):
            for j in range(len(box)):
                if weight[i] >= box[j]:
                    box.pop(j)
                    break
    print(time)