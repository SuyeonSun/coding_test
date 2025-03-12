from collections import deque
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

N = int(input())
board = []
for i in range(N):
    board.append(list(map(int, input())))

def bfs(i, j):
    queue = deque([])
    queue.append([i, j])
    board[i][j] = -1
    cnt = 1
    while queue:
        x, y = queue.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if board[nx][ny] == 1:
                queue.append([nx, ny])
                board[nx][ny] = -1
                cnt += 1
    return cnt
    
answer = []
for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            c = bfs(i, j)
            answer.append(c)

print(len(answer))
answer.sort()
for i in answer:
    print(i)