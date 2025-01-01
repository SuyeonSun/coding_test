from collections import deque

def bfs(L, start, target):
    moves = [(-2, -1), (-1, -2), (1, -2), (2, -1), 
             (2, 1), (1, 2), (-1, 2), (-2, 1)]
    visited = [[False] * L for _ in range(L)]
    queue = deque([[start[0], start[1], 0]])  # (x, y, 이동 횟수)
    visited[start[0]][start[1]] = True

    while queue:
        x, y, count = queue.popleft()
        if [x, y] == target:
            return count
        for dx, dy in moves:
            nx, ny = x + dx, y + dy
            if nx < 0 or ny < 0 or nx >= L or ny >= L:
                continue
            if not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append([nx, ny, count + 1])
    return -1

T = int(input())
for _ in range(T):
    L = int(input())
    start = list(map(int, input().split()))
    target = list(map(int, input().split()))

    # 시작점과 목표 지점이 같은 경우
    if start == target:
        print(0)
    else:
        print(bfs(L, start, target))