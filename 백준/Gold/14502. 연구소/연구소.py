from collections import deque
import sys
import copy

# 입력 받기
n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
answer = 0

# BFS로 바이러스 확산
def bfs():
    queue = deque()
    tmp_graph = copy.deepcopy(graph)  # 연구소 복사

    # 바이러스 위치 큐에 삽입
    for i in range(n):
        for j in range(m):
            if tmp_graph[i][j] == 2:
                queue.append((i, j))

    # BFS 탐색 (바이러스 퍼뜨리기)
    while queue:
        x, y = queue.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < n and 0 <= ny < m and tmp_graph[nx][ny] == 0:
                tmp_graph[nx][ny] = 2
                queue.append((nx, ny))

    # 안전 영역 크기 계산
    global answer
    safe_area = sum(row.count(0) for row in tmp_graph)
    answer = max(answer, safe_area)

# 백트래킹을 사용하여 벽을 세우는 함수
def makeWall(cnt, start):
    if cnt == 3:  # 벽 3개를 세운 경우, 바이러스 확산 실행
        bfs()
        return

    # 중복 방지를 위해 start부터 탐색
    for idx in range(start, n * m):
        x, y = divmod(idx, m)  # 1차원 index를 2차원 좌표로 변환
        if graph[x][y] == 0:  # 빈 칸에만 벽 세우기
            graph[x][y] = 1
            makeWall(cnt + 1, idx + 1)  # 다음 위치부터 탐색
            graph[x][y] = 0  # 백트래킹 (원상복구)

# 벽 세우기 시작
makeWall(0, 0)

# 결과 출력
print(answer)
