from collections import deque

def solution(maps):
    answer = 0
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    def bfs(i, j, cnt, maps): # isVisited를 쓰면 안되는 문제: 벽이 있기 때문에
        queue = deque()
        queue.append([i, j, cnt])
        while queue:
            x, y, cnt = queue.popleft()
            
            if x == len(maps) -1 and y == len(maps[0]) -1:
                return cnt
            
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or ny < 0 or nx >= len(maps) or ny >= len(maps[0]):
                    continue
                if maps[nx][ny] == 1:
                    maps[nx][ny] = -1
                    queue.append([nx, ny, cnt+1])
        return -1
            
    answer = bfs(0, 0, 1, maps) # 시작점을 1로 시작
    
    return answer