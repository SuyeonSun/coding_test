from collections import deque

dx = [[1, -1], [0, 0]]
dy = [[0, 0], [1, -1]]

def bfs(i, j):
    queue = deque([])
    queue.append([i, j])
    shape = 0
    if arr[i][j] == "-":
        shape = 1
    while queue:
        x, y = queue.popleft()
        for d in range(2):
            nx = x + dx[shape][d]
            ny = y + dy[shape][d]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if not visited[nx][ny] and arr[nx][ny] == arr[i][j]:
                queue.append([nx, ny])
                visited[nx][ny] = True

answer = 0
n, m = map(int, input().split())
arr = []
for i in range(n):
    arr.append(list(input()))
visited = [[False for _ in range(m)] for _ in range(n)]
for i in range(n):
    for j in range(m):
        if not visited[i][j]:
            bfs(i, j)
            answer += 1
print(answer)
