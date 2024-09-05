from collections import deque

def solution(x, y, n):
    visited = [0] * 1000001
    
    q = deque()
    q.append((x, 0))
    visited[x] = 1
    
    while q:
        num, cnt = q.popleft() # bfs의 핵심
        if num == y:
            return cnt
        for next_num in (num + n, num * 2, num * 3):
            if next_num <= y and not visited[next_num]:
                visited[next_num] = 1
                q.append((next_num, cnt + 1))
    
    return -1