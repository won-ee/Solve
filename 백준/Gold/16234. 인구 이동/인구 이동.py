from  collections import deque
import copy,sys
input = sys.stdin.readline

def bfs(ny,nx):
    q = deque()
    q.append((ny,nx))
    people = set()
    people.add((ny,nx))
    while q:
        y,x = q.popleft()

        for k in range(4):
            dy = diy[k] + y
            dx = dix[k] + x
            if dy < 0 or dy >= N or dx < 0 or dx >= N:
                continue
            if border[dy][dx] == 1:
                continue
            if (dy,dx) in people:
                continue
            if L <= abs(arr[y][x] - arr[dy][dx]) <= R:
                border[dy][dx] = 1
                q.append((dy,dx))
                people.add((dy,dx))

    #인구이동
    sum_people = 0
    for y,x in people:
        sum_people += arr[y][x]
    avg_people = int(sum_people / len(people))
    if avg_people == sum_people:
        return
    for y,x in people:
        backup_arr[y][x] = avg_people


N, L, R = map(int,input().split())
arr = []
diy = [0,0,1,-1]
dix = [1,-1,0,0]
ans = 0

for _ in range(N):
    arr.append(list(map(int, input().split())))

while 1:
    border = [[0] * N for _ in range(N)]
    backup_arr = copy.deepcopy(arr)
    # 국경체크
    for i in range(N):
        for j in range(N):
            if border[i][j] ==0:
                border[i][j] = 1
                bfs(i,j)

    if arr == backup_arr:
        break
    arr = copy.deepcopy(backup_arr)
    ans += 1

print(ans)