from collections import deque

N, K = map(int, input().split())
arr = [list(map(int, input())) for _ in range(2)]
used = [[0] * N for _ in range(2)]  # 방문 체크 배열
q = deque([(0, 0, 0)])  # (트랙, 인덱스, 시간)
used[0][0] = 1  # 시작 위치 방문 처리

while q:
    line, idx, time = q.popleft()

    # 3가지 이동을 확인
    for d_line, d_idx in [(0, 1), (0, -1), (1, K)]:
        n_line = (line + d_line) % 2  # 반대편 트랙으로 이동할 때
        n_idx = idx + d_idx if d_line == 0 else idx + K

        if n_idx >= N:  # 게임 클리어 조건
            print(1)
            exit()
        if n_idx < 0 or n_idx <= time:  # 이미 사라진 칸이거나 이동 불가능한 칸
            continue
        if arr[n_line][n_idx] == 0 or used[n_line][n_idx]:  # 위험한 칸이거나 이미 방문한 칸
            continue

        used[n_line][n_idx] = 1  # 방문 처리
        q.append((n_line, n_idx, time + 1))

print(0)
