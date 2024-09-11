from collections import deque    

def solution(maps):
    answer = []
    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    def bfs(i, j):
        queue = deque()
        queue.append([i, j])
        total = int(maps[i][j])
        
        while queue:
            pop = queue.popleft()
            for i in range(4):
                nx = pop[0] + dx[i]
                ny = pop[1] + dy[i]
                if nx < 0 or ny < 0 or nx >= len(maps) or ny >= len(maps[0]):
                    continue
                if maps[nx][ny] == "X":
                        continue
                if not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append([nx, ny])
                    total += int(maps[nx][ny])
                    
        answer.append(total)
        
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] != "X" and visited[i][j] == False:
                visited[i][j] = True
                bfs(i, j)
    
    if len(answer) == 0:
        return [-1]
    
    answer.sort()
    
    return answer