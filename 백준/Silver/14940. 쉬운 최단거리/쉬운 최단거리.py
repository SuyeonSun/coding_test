from collections import deque

# 입력 받기
n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

distance = [[-1] * m for _ in range(n)]

target_x, target_y = 0, 0
for i in range(n):
    for j in range(m):
        if grid[i][j] == 2:  # 목표 지점 찾기
            target_x, target_y = i, j
            distance[i][j] = 0  # 시작점의 거리 초기화

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

queue = deque()
queue.append((target_x, target_y))

while queue:
    x, y = queue.popleft()
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue
        if distance[nx][ny] == -1 and grid[nx][ny] == 1:  # 방문하지 않았고, 이동 가능하면
            distance[nx][ny] = distance[x][y] + 1
            queue.append((nx, ny))

# 원래 갈 수 없는 지역은 그대로 0으로 표시
for i in range(n):
    for j in range(m):
        if grid[i][j] == 0:
            distance[i][j] = 0
    print(" ".join(map(str, distance[i])))