from collections import deque

def solution(maps):
    global answer
    answer = 0
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    
    def bfs():
        queue = deque([])
        queue.append([0, 0, 1])
        visited[0][0] = True
        while queue:
            x, y, c = queue.popleft()
            if x == len(maps) -1 and y == len(maps[0]) -1:
                return c
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or ny < 0 or nx >= len(maps) or ny >= len(maps[0]):
                    continue
                if not visited[nx][ny] and maps[nx][ny] == 1:
                    queue.append([nx, ny, c + 1])
                    visited[nx][ny] = True
        return -1
    
    answer = bfs()
    
    return answer