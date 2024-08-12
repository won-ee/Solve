from collections import deque
import sys
input = sys.stdin.readline

def bfs(start_node):
    visited = [0] * (N + 1)
    q = deque([start_node])
    visited[start_node] = 1
    count = 1

    while q:
        node = q.popleft()
        for neighbor in network[node]:
            if not visited[neighbor]:
                q.append(neighbor)
                visited[neighbor] = 1
                count += 1

    return count


N, M = map(int, input().split())
network = [[] for _ in range(N + 1)]

for _ in range(M):
    A, B = map(int, input().split())
    network[B].append(A)

max_hackable_count = 0
result_computers = []

for i in range(1, N + 1):
    hackable_count = bfs(i)
    if max_hackable_count < hackable_count:
        max_hackable_count = hackable_count
        result_computers = [i]
    elif max_hackable_count == hackable_count:
        result_computers.append(i)

print(*result_computers)
