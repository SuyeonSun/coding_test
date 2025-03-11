from collections import deque

N, M = map(int, input().split())
grid = []
for i in range(N):
    grid.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    queue = deque()
    queue.append([0, 0, 1])
    grid[0][0] = 0
    while queue:
        x, y, c = queue.popleft()
        if x == N - 1 and y == M - 1:
            return c
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            if grid[nx][ny] == 1:
                grid[nx][ny] = 0
                queue.append([nx, ny, c + 1])


answer = bfs()
print(answer)