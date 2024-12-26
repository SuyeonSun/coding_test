from collections import deque

N = int(input())
colors = []
for i in range(N):
    colors.append(list(input()))
visited = [[False for _ in range(N)] for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(i, j, color, isAvg):
    queue = deque([])
    queue.append([i, j])
    while queue:
        x, y = queue.popleft()
        visited[x][y] = True
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if isAvg:
                if not visited[nx][ny] and colors[nx][ny] == color:
                    visited[nx][ny] = True
                    queue.append([nx, ny])
            else:
                if not visited[nx][ny]:
                    if (color == "R" or color == "G") and (colors[nx][ny] == "R" or colors[nx][ny] == "G"):
                        visited[nx][ny] = True
                        queue.append([nx, ny])
                    elif colors[nx][ny] == color:
                        visited[nx][ny] = True
                        queue.append([nx, ny])

avg_answer = 0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            avg_answer += 1
            bfs(i, j, colors[i][j], True)

visited = [[False for _ in range(N)] for _ in range(N)]
color_answer = 0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            color_answer += 1
            bfs(i, j, colors[i][j], False)

print(avg_answer, color_answer)