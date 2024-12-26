from collections import deque

M, N, H = map(int, input().split())
box = []
for _ in range(H):
    layer = [list(map(int, input().split())) for _ in range(N)]
    box.append(layer)

# 이동 방향 (상, 하, 좌, 우, 위, 아래)
directions = [(1, 0, 0), (-1, 0, 0), (0, 1, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1)]

# BFS 초기화
queue = deque()
for z in range(H):
    for y in range(N):
        for x in range(M):
            if box[z][y][x] == 1:  # 익은 토마토
                queue.append((z, y, x, 0))  # 좌표와 날짜 추가

# BFS 수행
max_days = 0
while queue:
    z, y, x, days = queue.popleft()
    max_days = max(max_days, days)
    for dz, dy, dx in directions:
        nz, ny, nx = z + dz, y + dy, x + dx
        if 0 <= nz < H and 0 <= ny < N and 0 <= nx < M:
            if box[nz][ny][nx] == 0:  # 익지 않은 토마토
                box[nz][ny][nx] = 1
                queue.append((nz, ny, nx, days + 1))

# 결과 확인
for z in range(H):
    for y in range(N):
        if 0 in box[z][y]:  # 익지 않은 토마토가 있으면
            print(-1)
            exit()

print(max_days)