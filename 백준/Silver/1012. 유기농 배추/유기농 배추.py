from collections import deque

T = int(input())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(i, j, farm, M, N):
    queue = deque([])
    queue.append([i, j])
    while queue:
        x, y = queue.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if nx < 0 or ny < 0 or nx >= M or ny >= N:
                continue
            if farm[nx][ny] == 1:
                farm[nx][ny] = 0
                queue.append([nx, ny])


for test_case in range(T):
    M, N, K = map(int, input().split())
    farm = [[0 for _ in range(N)] for _ in range(M)]
    for i in range(K):
        x, y = map(int, input().split())
        farm[x][y] = 1
    answer = 0
    for i in range(M):
        for j in range(N):
            if farm[i][j] == 1:
                answer += 1
                bfs(i, j, farm, M, N)
    print(answer)