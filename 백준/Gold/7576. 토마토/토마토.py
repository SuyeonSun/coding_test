from collections import deque

# 입력 받기
M, N = map(int, input().split())
box = []
for _ in range(N):
    box.append(list(map(int, input().split())))

# 방향 벡터 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# BFS 함수
def bfs():
    while queue:
        x, y = queue.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            # 범위를 벗어나지 않고 익지 않은 토마토(0)인 경우
            if 0 <= nx < N and 0 <= ny < M and box[nx][ny] == 0:
                box[nx][ny] = box[x][y] + 1
                queue.append((nx, ny))

# 초기 큐 설정: 익은 토마토(1)를 모두 큐에 추가
queue = deque()
for i in range(N):
    for j in range(M):
        if box[i][j] == 1:
            queue.append((i, j))

# BFS 실행
bfs()

# 결과 계산
max_days = 0
for i in range(N):
    for j in range(M):
        if box[i][j] == 0:  # 익지 않은 토마토가 남아있다면
            print(-1)
            exit()
        max_days = max(max_days, box[i][j])

# 결과 출력: 처음 익은 토마토가 1로 시작했으므로 결과에서 1을 뺌
print(max_days - 1)
