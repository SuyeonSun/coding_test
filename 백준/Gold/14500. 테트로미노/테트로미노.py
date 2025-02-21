import sys
input = sys.stdin.readline

# 상, 하, 좌, 우 방향
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, depth, total):
    global max_sum
    if depth == 4:
        max_sum = max(max_sum, total)
        return
    
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
            visited[nx][ny] = True
            dfs(nx, ny, depth + 1, total + grid[nx][ny])
            visited[nx][ny] = False

def check_exception(x, y):
    global max_sum
    # 중심과 인접한 4칸 중 3칸 선택
    total = grid[x][y]
    for i in range(4):
        tmp = total
        cnt = 0
        for j in range(3):
            t = (i + j) % 4
            nx, ny = x + dx[t], y + dy[t]
            if 0 <= nx < n and 0 <= ny < m:
                tmp += grid[nx][ny]
                cnt += 1
        if cnt == 3:
            max_sum = max(max_sum, tmp)

# 입력
n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
max_sum = 0

# 모든 좌표에서 시작
for i in range(n):
    for j in range(m):
        visited[i][j] = True
        dfs(i, j, 1, grid[i][j])
        visited[i][j] = False
        check_exception(i, j)

print(max_sum)
